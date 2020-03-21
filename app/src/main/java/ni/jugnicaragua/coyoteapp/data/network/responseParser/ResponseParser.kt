package ni.jugnicaragua.coyoteapp.data.network.responseParser

import okhttp3.Interceptor
import okhttp3.Response
import org.json.JSONObject
import java.lang.Exception

//class ResponseParser : Interceptor {
//
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val request = chain.request()
//        val response = chain.proceed(request)
//        println("RESPONSEEEEE")
//        try {
//            val jsonArrayData = (response.body.toString())
//            println("Arreglo de json ${jsonArrayData}")
//            //rest of your code
//        } catch (e: Exception) {
//            //"data" returns a string
//            e.printStackTrace()
//        }
//        return response
//    }
//}

/*
val clientBuilder = OkHttpClient.Builder()
clientBuilder.addInterceptor { chain ->
            val request = chain.request()
            val response = chain.proceed(request)
            if (response.code() == 403) {
                handleForbiddenResponse()
            }
            response
        }

        try {
            // "data" returns an object
            val jsonObjectData: JSONObject = body!!.getJSONObject("data")
            //rest of your code
        } catch (e: JSONException) {
            //"data" returns a string
            e.printStackTrace()
            try {
                val data: String = jsonObject.getString("data")
            } catch (e1: JSONException) {
                e1.printStackTrace()
            }
        }
 */