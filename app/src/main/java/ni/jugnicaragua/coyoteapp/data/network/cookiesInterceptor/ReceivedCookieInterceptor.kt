package ni.jugnicaragua.coyoteapp.data.network.cookiesInterceptor

import ni.jugnicaragua.coyoteapp.base.BaseApplication
import ni.jugnicaragua.coyoteapp.preferences.AppPreferences
import okhttp3.Interceptor
import okhttp3.Response

class ReceivedCookieInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalResponse = chain.proceed(chain.request())
        if (originalResponse.headers("Set-Cookie").isNotEmpty()) {
            val cookies: HashSet<String> = hashSetOf()
            for (header in originalResponse.headers("Set-Cookie")) {
                cookies.add(header)
            }
            AppPreferences(BaseApplication.context).put(AppPreferences.Key.cookies, cookies)
        }
        return originalResponse
    }
}