package ni.jugnicaragua.coyoteapp.data.network.interfaces

import ni.jugnicaragua.coyoteapp.model.Root
import ni.jugnicaragua.coyoteapp.util.UseCaseResult
import retrofit2.http.GET

interface ComercialBanksInterface {
    @GET("api/commercialBankExchangeRates")
    suspend fun requestExchangeRates(): UseCaseResult<Root>
}