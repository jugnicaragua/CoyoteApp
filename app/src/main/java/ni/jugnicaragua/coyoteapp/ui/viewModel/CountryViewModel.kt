package ni.jugnicaragua.coyoteapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.herbario_nacional.R
import com.example.herbario_nacional.models.countries.Country
import com.example.herbario_nacional.repo.CountryRepository
import com.example.herbario_nacional.ui.Event
import kotlinx.coroutines.launch
import ni.jugnicaragua.coyoteapp.data.local.database.dao.BanksDao
import ni.jugnicaragua.coyoteapp.model.Root
import ni.jugnicaragua.coyoteapp.repository.ComercialBanksRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class CountryViewModel (private val countryRepository: ComercialBanksRepository): ViewModel() , KoinComponent{

    private val welcomeDao: BanksDao by inject()
    private val _uiState = MutableLiveData<Root>()


    val uiState: LiveData<Root>
        get() = _uiState

    fun requestCountry() {
        viewModelScope.launch {
            runCatching {
                emitUiState(showProgress = true)
                welcomeDao.insertBankModel()
                countryRepository.getExchangeRates()
            }.onSuccess {
               // emitUiState(result = Event(it))
            }.onFailure {
               // emitUiState(error = Event(R.string.internet_connection_error))
            }
        }
    }

    fun emitUiState(
        showProgress: Boolean = false,
        result: Event<List<Country>>? = null,
        error: Event<Int>? = null){
        val dataState = CountryDataState(
            showProgress,
            result,
            error
        )
        _uiState.value = dataState
    }

    data class CountryDataState(
        val showProgress: Boolean,
        val result: Event<List<Country>>?,
        val error: Event<Int>?)
}