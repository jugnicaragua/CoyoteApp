package ni.jugnicaragua.coyoteapp.model

import androidx.annotation.Keep
import ni.jugnicaragua.coyoteapp.model.banks.Banks
import org.json.JSONException

import org.json.JSONObject




@Keep
data class Root(
    val `data`: List<Banks>,
    val size: Int // 6
)

fun Root.parseData(){

}

fun demo(){
//    try {
//        // "data" returns an object
//        val jsonObjectData: JSONObject = jsonObject.getJSONObject("data")
//        //rest of your code
//    } catch (e: JSONException) {
//        //"data" returns a string
//        e.printStackTrace()
//        try {
//            val data: String = jsonObject.getString("data")
//        } catch (e1: JSONException) {
//            e1.printStackTrace()
//        }
//    }
}

/*
class UserResponse {
  @SerializedName("status")
  var status:String
  @SerializedName("data")
  private val mData:Any
  @SerializedName("response")
  val response:String
  @SerializedName("error")
  val error:String
  var message:String
  var firstname:String
  var lastname:String
  var mobilenumber:String
  var emailid:String
  var timezone:String
  fun getmData():Any {
    return mData
  }
  class DataStateDeserializer:JsonDeserializer<UserResponse> {
    @Throws(JsonParseException::class)
    fun deserialize(json:JsonElement, typeOfT:Type, context:JsonDeserializationContext):UserResponse {
      val userResponse = Gson().fromJson(json, UserResponse::class.java)
      val jsonObject = json.getAsJsonObject()
      if (jsonObject.has("data"))
      {
        val elem = jsonObject.get("data")
        if (elem != null && !elem.isJsonNull())
        {
          if (elem.isJsonPrimitive())
          {
            userResponse.message = elem.getAsString()
          }
          else
          {
            userResponse.firstname = elem.getAsJsonObject().get("firstname").getAsString()
            userResponse.lastname = elem.getAsJsonObject().get("lastname").getAsString()
            userResponse.mobilenumber = elem.getAsJsonObject().get("mobilenumber").getAsString()
            userResponse.emailid = elem.getAsJsonObject().get("emailid").getAsString()
            userResponse.timezone = elem.getAsJsonObject().get("timezone").getAsString()
          }
        }
      }
      return userResponse
    }
  }
}
 */