package ni.jugnicaragua.coyoteapp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ni.jugnicaragua.coyoteapp.model.exchangeRate.centralBank.CentralBank

@Dao
interface CentralBankDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCentralBankModel(centralBankTable: CentralBank)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(centralBankTable: List<CentralBank>)

    @Query("DELETE FROM CentralBank")
    fun removeAll()

    @Query("select * from CentralBank")
    fun getAll(): List<CentralBank>

    @Query("select * from CentralBank where date = :currentDate")
    fun getByDate(currentDate: String): CentralBank

}