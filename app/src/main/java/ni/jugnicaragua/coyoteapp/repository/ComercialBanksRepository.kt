package ni.jugnicaragua.coyoteapp.repository

import ni.jugnicaragua.coyoteapp.data.network.interfaces.ComercialBanksInterface
import ni.jugnicaragua.coyoteapp.model.Root
import ni.jugnicaragua.coyoteapp.util.UseCaseResult

interface ComercialBanksRepository {
    suspend fun getExchangeRates(): UseCaseResult<Root>
}
//class ComercialBanksRepositoryImplement(private val comercialBanksService: ComercialBanksInterface, val banksDao: BanksDao): ComercialBanksRepository{
class ComercialBanksRepositoryImplement(private val comercialBanksService: ComercialBanksInterface): ComercialBanksRepository{
    override suspend fun getExchangeRates(): UseCaseResult<Root> {
        return comercialBanksService.requestExchangeRates()
    }
}