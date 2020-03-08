package ni.jugnicaragua.coyoteapp.repository

import ni.jugnicaragua.coyoteapp.data.network.interfaces.ComercialBanksInterface
import ni.jugnicaragua.coyoteapp.model.Root

interface ComercialBanksRepository {
    suspend fun getExchangeRates(): Root
}

class ComercialBanksRepositoryImplement(private val comercialBanksService: ComercialBanksInterface): ComercialBanksRepository{
    override suspend fun getExchangeRates(): Root {
        return comercialBanksService.requestExchangeRates()
    }
}