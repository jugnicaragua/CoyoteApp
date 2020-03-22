package ni.jugnicaragua.coyoteapp.di

import ni.jugnicaragua.coyoteapp.repository.CentralBankRepository
import ni.jugnicaragua.coyoteapp.repository.CentralBankRepositoryImplement
import ni.jugnicaragua.coyoteapp.repository.ComercialBanksRepository
import ni.jugnicaragua.coyoteapp.repository.ComercialBanksRepositoryImplement
import org.koin.dsl.module

val repositoryModule = module {
    single<ComercialBanksRepository> {
        ComercialBanksRepositoryImplement(get())
    }

    single<CentralBankRepository> {
        CentralBankRepositoryImplement(get())
    }
}