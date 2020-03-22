package ni.jugnicaragua.coyoteapp.di

import android.app.Application
import androidx.room.Room
import ni.jugnicaragua.coyoteapp.data.local.database.CoyoteDb
import ni.jugnicaragua.coyoteapp.data.local.database.dao.BanksDao
import ni.jugnicaragua.coyoteapp.data.local.database.dao.CentralBankDao
import ni.jugnicaragua.coyoteapp.data.local.database.dao.ExchangeRateDao
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    fun provideDatabase(application: Application): CoyoteDb {
        return Room.databaseBuilder(application, CoyoteDb::class.java, "coyote.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    fun provideBanksDao(database: CoyoteDb): BanksDao {
        return database.banksDbTableDao()
    }

    fun provideExchangeRateDao(database: CoyoteDb): ExchangeRateDao {
        return database.exchangeRateDbTableDao()
    }

    fun provideCentralBankDao(database: CoyoteDb): CentralBankDao {
        return database.centralBankDbTableDao()
    }

    single { provideDatabase(androidApplication()) }
    single { provideBanksDao(get()) }
    single { provideExchangeRateDao(get()) }
    single { provideCentralBankDao(get()) }
}