package com.example.di

import com.example.data.datasource.repository.PokedexRepositoryImpl
import com.example.domain.repository.PokedexRepository
import org.koin.dsl.module

val dataModule = module {

    single<PokedexRepository> { PokedexRepositoryImpl(get()) }


}