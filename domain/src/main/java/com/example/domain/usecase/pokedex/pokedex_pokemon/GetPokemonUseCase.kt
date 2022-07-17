package com.example.domain.usecase.pokedex.pokedex_pokemon

import com.example.domain.core.UseCase
import com.example.domain.exception.MissingParamsException
import com.example.domain.model.pokedex.PokemonModel
import com.example.domain.repository.PokedexRepository
import kotlinx.coroutines.CoroutineScope

class GetPokemonUseCase(
    scope: CoroutineScope,
    private val repository: PokedexRepository
) : UseCase<PokemonModel, GetPokemonUseCase.Params>(scope) {

    override fun run(params: Params?) = when (params) {
        null -> throw MissingParamsException()
        else -> repository.searchPokemon(name = params.name)
    }

    data class Params(
       val name: String
    )
}
