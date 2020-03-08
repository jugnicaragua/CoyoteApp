package ni.jugnicaragua.coyoteapp.data.network

import ni.jugnicaragua.coyoteapp.BuildConfig
import ni.jugnicaragua.coyoteapp.data.network.cookiesInterceptor.ReceivedCookieInterceptor
import ni.jugnicaragua.coyoteapp.data.network.headerInterceptor.HeaderInterceptor
import ni.jugnicaragua.coyoteapp.data.network.interfaces.ComercialBanksInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val remoteDataSourceModule = module {
    single { createOkHttpClient() }
    single { createWebService<ComercialBanksInterface>(get(), BuildConfig.COYOTE_SERVICE) }
}

fun createOkHttpClient(): OkHttpClient {
    return getOkHttpClient()
}

fun getOkHttpClient(): OkHttpClient{
    return OkHttpClient
        .Builder()
        .addInterceptor(HeaderInterceptor())
        .apply {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            interceptors().add(ReceivedCookieInterceptor())
        }
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()
}

inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
    return retrofit.create(T::class.java)
}