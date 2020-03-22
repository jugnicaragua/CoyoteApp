package ni.jugnicaragua.coyoteapp.repository

import ni.jugnicaragua.coyoteapp.data.network.interfaces.CentralBankInterface
import ni.jugnicaragua.coyoteapp.model.exchangeRate.centralBank.CentralBank


interface CentralBankRepository {
    suspend fun getCentralBankExchangeToday(): CentralBank
}

class CentralBankRepositoryImplement(private val centralBankService: CentralBankInterface): CentralBankRepository{
    override suspend fun getCentralBankExchangeToday(): CentralBank {
        return centralBankService.requestCentralBankCurrentExchange()
    }
}