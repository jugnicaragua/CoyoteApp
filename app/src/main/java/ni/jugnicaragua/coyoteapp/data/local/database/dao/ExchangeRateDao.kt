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

    @Query("select * from ExchangeRate")
    fun getAll(): List<ExchangeRate>
}