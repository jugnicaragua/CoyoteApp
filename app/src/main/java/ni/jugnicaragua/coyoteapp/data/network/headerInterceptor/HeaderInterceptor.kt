package ni.jugnicaragua.coyoteapp.data.network.headerInterceptor

import kotlinx.coroutines.withContext
import ni.jugnicaragua.coyoteapp.base.BaseApplication
import ni.jugnicaragua.coyoteapp.preferences.AppPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    companion object ApiConstants{
        const val EXCHANGE_RATE = "/api/commercialBankExchangeRates"
        const val EXCHANGE_RATE_DATE = "/api/commercialBankExchangeRates/date"
        const val EXCHANGE_RATE_DATE_TODAY = "/api/commercialBankExchangeRates/date/today"
        const val CENTRAL_BANK_EXCHANGE_TODAY = "/api/centralBankExchangeRates/today"
    }

    private fun setupCookies(){
        val cookies = AppPreferences(BaseApplication.context).get(AppPreferences.Key.cookies, HashSet<String>()) as HashSet<*>
        var content = ""
        cookies.forEach {
            content += it as String
        }
        requestBuilder.addHeader("Cookie", content)
    }

    private lateinit var requestBuilder: Request.Builder

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        requestBuilder = request.newBuilder()
        when (request.url.encodedPath) {
            EXCHANGE_RATE -> {
                requestBuilder
                    .addHeader("Content-Type", "application/json")
            }
            EXCHANGE_RATE_DATE -> {
                requestBuilder
                    .addHeader("Content-Type", "application/json")
            }
            EXCHANGE_RATE_DATE_TODAY -> {
                requestBuilder
                    .addHeader("Content-Type", "application/json")
            }
            CENTRAL_BANK_EXCHANGE_TODAY -> {
                requestBuilder
                    .addHeader("Content-Type", "application/json")
            }
            else -> {
                requestBuilder
                    .addHeader("Content-Type", "application/json")
            }
        }
        setupCookies()
        request = requestBuilder.build()
        return chain.proceed(request)
    }
}