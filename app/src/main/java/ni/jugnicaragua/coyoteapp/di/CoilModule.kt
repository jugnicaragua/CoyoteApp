package ni.jugnicaragua.coyoteapp.di

import ni.jugnicaragua.coyoteapp.imageloader.CoilImageLoader
import org.koin.dsl.module

val coilModule = module {
    factory {
        CoilImageLoader()
    }
}