package ni.jugnicaragua.coyoteapp.di

import ni.jugnicaragua.coyoteapp.data.network.remoteDataSourceModule
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
//    viewModel { CredentialsViewModel(get()) }
//    viewModel { RegisterViewModel(get()) }
//    viewModel { ProfileViewModel(get()) }
//    viewModel { CountryViewModel(get()) }
//
//    single<CredentialsRepository> {
//        CredentialsRepositoryImpl(get())
//    }
//
//    single<RegisterRepository> {
//        RegisterRepositoryImpl(get())
//    }
//
//    single<CountryRepository> {
//        CountryRepositoryImpl(get())
//    }
//
//    single<ProfileRepository> {
//        ProfileRepositoryImpl(get())
//    }
}

val allAppModules = listOf(appModule, remoteDataSourceModule, coilModule, preferencesModule, databaseModule)