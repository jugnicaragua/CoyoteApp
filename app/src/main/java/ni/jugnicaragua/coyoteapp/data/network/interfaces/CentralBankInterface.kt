package ni.jugnicaragua.coyoteapp.data.network.interfaces

import ni.jugnicaragua.coyoteapp.model.exchangeRate.centralBank.CentralBank
import retrofit2.http.GET

interface CentralBankInterface {
    @GET("api/centralBankExchangeRates/today")
    suspend fun requestCentralBankCurrentExchange(): CentralBank
}