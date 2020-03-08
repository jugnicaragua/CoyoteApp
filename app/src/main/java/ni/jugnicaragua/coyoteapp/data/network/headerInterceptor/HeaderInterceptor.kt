package ni.jugnicaragua.coyoteapp.data.network.headerInterceptor

import kotlinx.coroutines.withContext
import ni.jugnicaragua.coyoteapp.base.BaseApplication
import ni.jugnicaragua.coyoteapp.preferences.AppPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class HeaderInterceptor : Interceptor {
    companion object ApiConstants{
        const val LOGIN = "/api/login/"
        const val SIGN_UP = "/api/sign_up/"
        const val PROFILE = "api/profile/"
        const val COUNTRY = "api/country/"
        const val PLANT_SPECIMEN = "api/plant_specimen"
        const val PERMANENT_LOGIN = "/api/permanent_login/"
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
            LOGIN -> {
                requestBuilder
                    .addHeader("Content-Type", "application/json")
            }
            SIGN_UP -> {
                requestBuilder
                    .addHeader("Content-Type", "application/json")
            }
            PROFILE -> {
                requestBuilder
                    .addHeader("Content-Type", "application/json")
            }
            PLANT_SPECIMEN -> {
                requestBuilder
                    .addHeader("Content-Type", "application/json")
            }
            COUNTRY -> {
                requestBuilder
                    .addHeader("Content-Type", "application/json")
            }
            PERMANENT_LOGIN -> {
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