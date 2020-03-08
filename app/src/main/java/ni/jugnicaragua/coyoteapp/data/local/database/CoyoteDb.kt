package ni.jugnicaragua.coyoteapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ni.jugnicaragua.coyoteapp.data.local.database.dao.BanksDao
import ni.jugnicaragua.coyoteapp.data.local.database.dao.CentralBankDao
import ni.jugnicaragua.coyoteapp.data.local.database.dao.ExchangeRateDao
import ni.jugnicaragua.coyoteapp.model.banks.Banks
import ni.jugnicaragua.coyoteapp.model.exchangeRate.ExchangeRate
import ni.jugnicaragua.coyoteapp.model.exchangeRate.centralBank.CentralBank

@Database(entities = [Banks::class, ExchangeRate::class, CentralBank::class], version = 1, exportSchema = false)
abstract class CoyoteDb : RoomDatabase() {
    abstract fun banksDbTableDao(): BanksDao
    abstract fun exchangeRateDbTableDao(): ExchangeRateDao
    abstract fun centralBankDbTableDao(): CentralBankDao
}