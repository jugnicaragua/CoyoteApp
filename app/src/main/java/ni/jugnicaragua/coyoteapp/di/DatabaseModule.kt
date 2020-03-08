package ni.jugnicaragua.coyoteapp.di

import android.app.Application
import androidx.room.Room
import ni.jugnicaragua.coyoteapp.data.local.database.CoyoteDb
import ni.jugnicaragua.coyoteapp.data.local.database.dao.BanksDao
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

    single { provideDatabase(androidApplication()) }
    single { provideDao(get()) }
}