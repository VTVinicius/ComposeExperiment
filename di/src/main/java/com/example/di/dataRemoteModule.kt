package com.example.di

import com.example.data.datasource.remote.PokedexRemoteDataSource
import com.example.data_remote.datasource.PokedexRemoteDataSourceImpl
import com.example.data_remote.service.PokedexWebService
import com.example.data_remote.utils.POKEDEX_BASE_URL
import com.example.data_remote.utils.TIMEOUT_DURATION_SECONDS
import com.example.data_remote.utils.WebServiceFactory
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import java.util.concurrent.TimeUnit

val dataRemoteModule = module {

        single {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }
        single {
            Dispatcher().apply {
                maxRequests = 1
            }
        }
        single {
            OkHttpClient.Builder()
                .addInterceptor(get<HttpLoggingInterceptor>())
                .dispatcher(get())
                .readTimeout(TIMEOUT_DURATION_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_DURATION_SECONDS, TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT_DURATION_SECONDS, TimeUnit.SECONDS)
                .build()
        }

    single {
        WebServiceFactory.createWebService(
            get(),
            url = POKEDEX_BASE_URL
        ) as PokedexWebService
    }

    single<PokedexRemoteDataSource> { PokedexRemoteDataSourceImpl(get()) }

}