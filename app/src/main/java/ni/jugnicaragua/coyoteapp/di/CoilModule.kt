package ni.jugnicaragua.coyoteapp.di

import ni.jugnicaragua.coyoteapp.imageloader.CoilImageLoader
import ni.jugnicaragua.coyoteapp.imageloader.ImageLoader
import org.koin.dsl.module

val coilModule = module {
    factory {
        CoilImageLoader() as ImageLoader
    }
}