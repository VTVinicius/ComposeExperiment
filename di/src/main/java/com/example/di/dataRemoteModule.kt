package com.example.di

import com.example.data.datasource.remote.PokedexRemoteDataSource
import com.example.data_remote.datasource.PokedexRemoteDataSourceImpl
import com.example.data_remote.service.PokedexWebService
import com.example.data_remote.utils.POKEDEX_BASE_URL
import com.example.data_remote.utils.WebServiceFactory
import org.koin.dsl.module

val dataRemoteModule = module {

    single {
        WebServiceFactory.provideOkHttpClient(
            wasDebugVersion = true
        )
    }

    single {
        WebServiceFactory.createWebService(
            get(),
            url = POKEDEX_BASE_URL
        ) as PokedexWebService
    }

    single<PokedexRemoteDataSource> { PokedexRemoteDataSourceImpl(get()) }

}