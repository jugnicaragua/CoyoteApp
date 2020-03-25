package ni.jugnicaragua.coyoteapp.repository

import ni.jugnicaragua.coyoteapp.data.network.interfaces.ComercialBanksInterface
import ni.jugnicaragua.coyoteapp.model.banks.RootBank
import ni.jugnicaragua.coyoteapp.model.exchangeRate.ExchangeRate
import ni.jugnicaragua.coyoteapp.model.exchangeRate.RootExchangeRate

interface ComercialBanksRepository {
    suspend fun getExchangeRates(): RootBank
    suspend fun getExchangeRateByBank(bankId: Int): ExchangeRate
    suspend fun getExchangeRateByDate(date: String): RootExchangeRate
    suspend fun getExchangeRateByDateRange(dateMap: HashMap<String, Any>): RootExchangeRate
    suspend fun getExchangeRateByToday(): RootExchangeRate
}

class ComercialBanksRepositoryImplement(private val comercialBanksService: ComercialBanksInterface): ComercialBanksRepository{
    override suspend fun getExchangeRates(): RootBank {
        return comercialBanksService.requestExchangeRates()
    }

    override suspend fun getExchangeRateByBank(bankId: Int): ExchangeRate {
        return comercialBanksService.requestExchangeRateByBankId(bankId)
    }

    override suspend fun getExchangeRateByDate(date: String): RootExchangeRate {
        return comercialBanksService.requestExchangeRateByDate(date)
    }

    override suspend fun getExchangeRateByDateRange(dateMap: HashMap<String, Any>): RootExchangeRate {
        return comercialBanksService.requestExchangeRateByDateRange(dateMap)
    }

    override suspend fun getExchangeRateByToday(): RootExchangeRate {
        return comercialBanksService.requestExchangeRateToday()
    }
}
