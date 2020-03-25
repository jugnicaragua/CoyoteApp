package ni.jugnicaragua.coyoteapp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ni.jugnicaragua.coyoteapp.model.exchangeRate.ExchangeRate

@Dao
interface ExchangeRateDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExchangeRateModel(exchangeRateTable: ExchangeRate)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(banksTable: List<ExchangeRate>)

    @Query("DELETE FROM ExchangeRate")
    fun removeAll()

    @Query("select * from ExchangeRate where date = :currentDate")
    fun getByToday(currentDate: String): List<ExchangeRate>

    @Query("select * from ExchangeRate where date between :startDate and :endDate")
    fun getByWeek(startDate: String, endDate: String): List<ExchangeRate>
}