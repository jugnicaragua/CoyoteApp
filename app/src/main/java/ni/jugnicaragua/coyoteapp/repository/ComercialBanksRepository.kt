package ni.jugnicaragua.coyoteapp.repository

import ni.jugnicaragua.coyoteapp.data.network.interfaces.ComercialBanksInterface
import ni.jugnicaragua.coyoteapp.model.Root
import ni.jugnicaragua.coyoteapp.model.exchangeRate.ExchangeRate
import ni.jugnicaragua.coyoteapp.util.UseCaseResult

interface ComercialBanksRepository {
    suspend fun getExchangeRates(): Root
    suspend fun getExchangeRateByBank(bankId: Int): ExchangeRate
    suspend fun getExchangeRateByDate(date: String): Root
    suspend fun getExchangeRateByDateRange(dateMap: HashMap<String, Any>): Root
}

class ComercialBanksRepositoryImplement(private val comercialBanksService: ComercialBanksInterface): ComercialBanksRepository{
    override suspend fun getExchangeRates(): Root {
        return comercialBanksService.requestExchangeRates()
    }

    override suspend fun getExchangeRateByBank(bankId: Int): ExchangeRate {
        return comercialBanksService.requestExchangeRateByBankId(bankId)
    }

    override suspend fun getExchangeRateByDate(date: String): Root {
        return comercialBanksService.requestExchangeRateByDate(date)
    }

    override suspend fun getExchangeRateByDateRange(dateMap: HashMap<String, Any>): Root {
        return comercialBanksService.requestExchangeRateByDateRange(dateMap)
    }
}
