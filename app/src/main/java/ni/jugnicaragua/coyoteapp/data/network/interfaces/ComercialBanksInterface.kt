package ni.jugnicaragua.coyoteapp.data.network.interfaces

import ni.jugnicaragua.coyoteapp.model.Root
import retrofit2.http.GET

interface ComercialBanksInterface {
    @GET("api/commercialBankExchangeRates")
    suspend fun requestExchangeRates(): Root
}