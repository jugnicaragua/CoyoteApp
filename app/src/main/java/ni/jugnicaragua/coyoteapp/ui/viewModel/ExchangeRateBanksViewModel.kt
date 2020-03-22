package ni.jugnicaragua.coyoteapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ni.jugnicaragua.coyoteapp.data.local.database.dao.BanksDao
import ni.jugnicaragua.coyoteapp.data.local.database.dao.ExchangeRateDao
import ni.jugnicaragua.coyoteapp.model.Event
import ni.jugnicaragua.coyoteapp.model.banks.Banks
import ni.jugnicaragua.coyoteapp.model.exchangeRate.ExchangeRate
import ni.jugnicaragua.coyoteapp.repository.ComercialBanksRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

class ExchangeRateBanksViewModel (private val comercialBanksRepository: ComercialBanksRepository): ViewModel() , KoinComponent{

    private val exchangeRateDao: ExchangeRateDao by inject()
    private val _uiState = MutableLiveData<CredentialsDataState>()
    val uiState: LiveData<CredentialsDataState> get() = _uiState

    init {
        viewModelScope.launch {
            runCatching {
                comercialBanksRepository.getExchangeRateByToday()
            }.onSuccess {root ->
                val nameMap: MutableList<ExchangeRate> = root.data.map { it }.toMutableList()
                exchangeRateDao.insertAll(nameMap.toList())
                requestExchangeRateToday()
            }.onFailure {
                println("fail: $it")
            }
        }
    }

    fun requestExchangeRateToday() = emitUiState(result = Event(exchangeRateDao.getAll()))

    private fun emitUiState(showProgress: Boolean = false, result: Event<List<ExchangeRate>>? = null, error: Event<Int>? = null){
        val dataState = CredentialsDataState(showProgress, result, error)
        _uiState.value = dataState
    }

    data class CredentialsDataState(val showProgress: Boolean, val result: Event<List<ExchangeRate>>?, val error: Event<Int>?)
}