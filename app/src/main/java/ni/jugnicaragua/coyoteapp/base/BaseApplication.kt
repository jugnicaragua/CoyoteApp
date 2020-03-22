package ni.jugnicaragua.coyoteapp.base

import android.app.Application
import ni.jugnicaragua.coyoteapp.BuildConfig
import ni.jugnicaragua.coyoteapp.di.remoteDataSourceModule
import ni.jugnicaragua.coyoteapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class BaseApplication : Application() {
    companion object{
        lateinit var context: BaseApplication
        val allAppModules = listOf(coilModule, repositoryModule, viewModelModule, remoteDataSourceModule, preferencesModule, databaseModule)
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        startKoin {
            androidLogger()
            androidContext(this@BaseApplication)
            modules(allAppModules)
        }
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}