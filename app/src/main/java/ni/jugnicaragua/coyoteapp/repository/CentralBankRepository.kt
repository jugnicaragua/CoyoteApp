package ni.jugnicaragua.coyoteapp.repository

import ni.jugnicaragua.coyoteapp.data.network.interfaces.CentralBankInterface
import ni.jugnicaragua.coyoteapp.model.exchangeRate.centralBank.CentralBank


interface CentralBankRepository {
    suspend fun getCentralBankExchangeToday(): CentralBank
    suspend fun getCentralBankExchangeByDate(requestedDate: String): CentralBank
}

class CentralBankRepositoryImplement(private val centralBankService: CentralBankInterface): CentralBankRepository{
    override suspend fun getCentralBankExchangeToday(): CentralBank {
        return centralBankService.requestCentralBankCurrentExchange()
    }

    override suspend fun getCentralBankExchangeByDate(requestedDate: String): CentralBank {
        return centralBankService.requestCentralBankCurrentExchangeByDate(requestedDate)
    }
}