package ni.jugnicaragua.coyoteapp.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ExchangeRateDao {

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertWeatherModel(weatherTable: WeatherEntity)
//
//    @Query("DELETE FROM WeatherTable WHERE dateTime = :dateTime ")
//    fun deleteWeatherModel(dateTime: Int)
//
//    @Query("DELETE FROM WeatherTable")
//    fun deleteAllWeathers()
//
//    @Query("select * from WeatherTable WHERE cityName = :city order by dateTime DESC")
//    fun loadAllWeathers(city: String): LiveData<List<WeatherEntity>>
//
//    @Query("select * from WeatherTable WHERE dateTime = :dateTime and cityName = :city ")
//    fun getWeather(dateTime: Long, city: String): LiveData<WeatherEntity>
}