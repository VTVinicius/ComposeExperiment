package com.example.di

import com.example.domain.core.ThreadContextProvider
import com.example.domain.repository.PokedexRepository
import com.example.domain.usecase.pokedex.pokedex_home.GetAllPokemonsUseCase
import com.example.domain.usecase.pokedex.pokedex_pokemon.GetPokemonUseCase
import com.example.domain.usecase.referenciadouso.ExampleUseCase
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module

val domainModule = module {

    single {
        ThreadContextProvider()
    }

    factory { (scope: CoroutineScope) ->
        ExampleUseCase(
            scope = scope,
            string = ""
        )
    }

    factory { (scope: CoroutineScope) ->
        GetAllPokemonsUseCase(
            scope = scope,
            repository = get()
        )
    }

    factory { (scope: CoroutineScope) ->
        GetPokemonUseCase(
            scope = scope,
            repository = get()
        )
    }


}
