package ni.jugnicaragua.coyoteapp.di

import ni.jugnicaragua.coyoteapp.ui.viewModel.CentralBankViewModel
import ni.jugnicaragua.coyoteapp.ui.viewModel.ExchangeRateBanksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ExchangeRateBanksViewModel(get()) }
    viewModel { CentralBankViewModel(get()) }
}