package ni.jugnicaragua.coyoteapp.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ni.jugnicaragua.coyoteapp.model.banks.Banks

@Dao
interface BanksDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBankModel(banksTable: Banks)

//    @Query("DELETE FROM WeatherTable WHERE dateTime = :dateTime ")
//    fun deleteWeatherModel(dateTime: Int)

    @Query("DELETE FROM Bank")
    fun removeAll()

//    @Query("select * from WeatherTable WHERE cityName = :city order by dateTime DESC")
//    fun loadAllWeathers(city: String): LiveData<List<WeatherEntity>>

    @Query("select * from Bank")
    fun getAll(): LiveData<List<Banks>>
}