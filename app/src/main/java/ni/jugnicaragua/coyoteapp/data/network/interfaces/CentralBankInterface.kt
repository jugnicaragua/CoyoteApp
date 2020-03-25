package ni.jugnicaragua.coyoteapp.data.network.interfaces

import ni.jugnicaragua.coyoteapp.model.exchangeRate.centralBank.CentralBank
import retrofit2.http.GET
import retrofit2.http.Path

interface CentralBankInterface {
    @GET("api/centralBankExchangeRates/today")
    suspend fun requestCentralBankCurrentExchange(): CentralBank

    @GET("api/centralBankExchangeRates/{dateSearch}")
    suspend fun requestCentralBankCurrentExchangeByDate(@Path("dateSearch") dateSearch: String): CentralBank
}