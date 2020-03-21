package ni.jugnicaragua.coyoteapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch
import ni.jugnicaragua.coyoteapp.data.local.database.dao.BanksDao
import ni.jugnicaragua.coyoteapp.model.Event
import ni.jugnicaragua.coyoteapp.model.Root
import ni.jugnicaragua.coyoteapp.model.banks.Banks
import ni.jugnicaragua.coyoteapp.repository.ComercialBanksRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class CountryViewModel (private val countryRepository: ComercialBanksRepository): ViewModel() , KoinComponent{

    private val welcomeDao: BanksDao by inject()
    private val _uiState = MutableLiveData<CredentialsDataState>()
    val uiState: LiveData<CredentialsDataState> get() = _uiState

    fun requestCountry() {
        viewModelScope.launch {
            runCatching {
                countryRepository.getExchangeRates()
            }.onSuccess {root ->
                val nameMap: MutableList<Banks> = root.data.map { it }.toMutableList()
                println(welcomeDao.insertAll(nameMap.toList()))
                emitUiState(result = Event(root))
            }.onFailure {
                println("fail")
                println(it)
            }
        }
    }

    inline fun <reified T> fromJson(json: String?): T {
        return Gson().fromJson<T>(json, object: TypeToken<T>(){}.type)
    }

    private fun emitUiState(showProgress: Boolean = false, result: Event<Root>? = null, error: Event<Int>? = null){
        val dataState = CredentialsDataState(showProgress, result, error)
        _uiState.value = dataState
    }

    data class CredentialsDataState(val showProgress: Boolean, val result: Event<Root>?, val error: Event<Int>?)

    fun demo(){
        println("DEMOOOO")
        println(welcomeDao.getAll())
        println("termino")
    }

}