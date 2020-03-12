package ni.jugnicaragua.coyoteapp.di

import ni.jugnicaragua.coyoteapp.data.network.remoteDataSourceModule
import ni.jugnicaragua.coyoteapp.repository.ComercialBanksRepository
import ni.jugnicaragua.coyoteapp.repository.ComercialBanksRepositoryImplement
import ni.jugnicaragua.coyoteapp.ui.viewModel.CountryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { CountryViewModel(get()) }
//    viewModel { RegisterViewModel(get()) }
//    viewModel { ProfileViewModel(get()) }
//    viewModel { CountryViewModel(get()) }
//
    single<ComercialBanksRepository> {
        ComercialBanksRepositoryImplement(get(), get())
    }
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