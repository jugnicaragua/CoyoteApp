package ni.jugnicaragua.coyoteapp.data.network.interfaces

import ni.jugnicaragua.coyoteapp.model.Root
import ni.jugnicaragua.coyoteapp.model.exchangeRate.ExchangeRate
import ni.jugnicaragua.coyoteapp.util.UseCaseResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface ComercialBanksInterface {
    @GET("api/commercialBankExchangeRates")
    suspend fun requestExchangeRates(): Root

    @GET("api/commercialBankExchangeRates/{idBank}")
    suspend fun requestExchangeRateByBankId(@Path("idBank") idBank: Int): ExchangeRate

    @GET("api/commercialBankExchangeRates/date/{dateSearch}")
    suspend fun requestExchangeRateByDate(@Path("dateSearch") dateSearch: String): Root

    @GET("api/commercialBankExchangeRates/date?")
    suspend fun requestExchangeRateByDateRange(@QueryMap(encoded = true) dateMap: HashMap<String, Any>): Root
}