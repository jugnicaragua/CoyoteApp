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
import ni.jugnicaragua.coyoteapp.util.*
import org.koin.core.KoinComponent
import org.koin.core.inject

class ExchangeRateBanksViewModel (private val comercialBanksRepository: ComercialBanksRepository): ViewModel() , KoinComponent{

    private val exchangeRateDao: ExchangeRateDao by inject()
    private val _uiState = MutableLiveData<CredentialsDataState>()
    val uiState: LiveData<CredentialsDataState> get() = _uiState

    init {
        viewModelScope.launch {
            runCatching {
                emitUiState(showProgress = true)
                comercialBanksRepository.getExchangeRateByToday()
            }.onSuccess {root ->
                val nameMap: MutableList<ExchangeRate> = root.data.map { it }.toMutableList()
                exchangeRateDao.insertAll(nameMap.toList())
                requestExchangeRateByDay(getCurrentDateTime().toString("yyy-MM-dd"))
            }.onFailure {
                requestExchangeRateByDay(getCurrentDateTime().toString("yyy-MM-dd"))
            }
        }
    }

    fun requestByDate(requestedDate: String){
        viewModelScope.launch {
            runCatching {
                emitUiState(showProgress = true)
                comercialBanksRepository.getExchangeRateByDate(requestedDate)
            }.onSuccess {root ->
                val nameMap: MutableList<ExchangeRate> = root.data.map { it }.toMutableList()
                exchangeRateDao.insertAll(nameMap.toList())
                requestExchangeRateByDay(requestedDate)
            }.onFailure {
                requestExchangeRateByDay(requestedDate)
            }
        }
    }

    fun requestExchangeRateByWeek() = emitUiState(result = Event(exchangeRateDao.getByWeek(getCalendar().getFirstDayWeek().toString("yyyy-MM-dd"), getCalendar().geLastDayWeek().toString("yyyy-MM-dd"))))

    fun requestExchangeRateByDay(requestedDate: String) = emitUiState(result = Event(exchangeRateDao.getByToday(requestedDate)))

    private fun emitUiState(showProgress: Boolean = false, result: Event<List<ExchangeRate>>? = null, error: Event<Int>? = null){
        val dataState = CredentialsDataState(showProgress, result, error)
        _uiState.value = dataState
    }

    data class CredentialsDataState(val showProgress: Boolean, val result: Event<List<ExchangeRate>>?, val error: Event<Int>?)
}