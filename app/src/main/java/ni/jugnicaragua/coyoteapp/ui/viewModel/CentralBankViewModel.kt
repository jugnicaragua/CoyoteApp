package ni.jugnicaragua.coyoteapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ni.jugnicaragua.coyoteapp.data.local.database.dao.BanksDao
import ni.jugnicaragua.coyoteapp.data.local.database.dao.CentralBankDao
import ni.jugnicaragua.coyoteapp.data.local.database.dao.ExchangeRateDao
import ni.jugnicaragua.coyoteapp.model.Event
import ni.jugnicaragua.coyoteapp.model.banks.Banks
import ni.jugnicaragua.coyoteapp.model.exchangeRate.ExchangeRate
import ni.jugnicaragua.coyoteapp.model.exchangeRate.centralBank.CentralBank
import ni.jugnicaragua.coyoteapp.repository.CentralBankRepository
import ni.jugnicaragua.coyoteapp.repository.ComercialBanksRepository
import ni.jugnicaragua.coyoteapp.util.getCurrentDateTime
import ni.jugnicaragua.coyoteapp.util.toString
import org.koin.core.KoinComponent
import org.koin.core.inject

class CentralBankViewModel (private val centralBankRepository: CentralBankRepository): ViewModel() , KoinComponent{

    private val centralBankDao: CentralBankDao by inject()
    private val _uiState = MutableLiveData<CredentialsDataState>()
    val uiState: LiveData<CredentialsDataState> get() = _uiState

    init {
        viewModelScope.launch {
            runCatching {
                centralBankRepository.getCentralBankExchangeToday()
            }.onSuccess {root ->
                centralBankDao.insertCentralBankModel(root)
                requestCentralBankExchangeToday()
            }.onFailure {
                println("fail: $it")
            }
        }
    }

    fun requestCentralBankExchangeToday() = emitUiState(result = Event(centralBankDao.getByDate(getCurrentDateTime().toString("yyyy-MM-dd"))))

    private fun emitUiState(showProgress: Boolean = false, result: Event<CentralBank>? = null, error: Event<Int>? = null){
        val dataState = CredentialsDataState(showProgress, result, error)
        _uiState.value = dataState
    }

    data class CredentialsDataState(val showProgress: Boolean, val result: Event<CentralBank>?, val error: Event<Int>?)
}