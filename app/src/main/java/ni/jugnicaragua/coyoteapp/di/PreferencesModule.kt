package ni.jugnicaragua.coyoteapp.di

import ni.jugnicaragua.coyoteapp.preferences.AppPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val preferencesModule = module {
    single { AppPreferences(androidContext()) }
}