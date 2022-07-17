package com.example.domain.usecase.pokedex.pokedex_home

import com.example.domain.core.UseCase
import com.example.domain.exception.MissingParamsException
import com.example.domain.model.pokedex.PokedexListModel
import com.example.domain.repository.PokedexRepository
import kotlinx.coroutines.CoroutineScope


class GetAllPokemonsUseCase(
    scope: CoroutineScope,
    private val repository: PokedexRepository
): UseCase<PokedexListModel, GetAllPokemonsUseCase.Params>(scope)  {

    override fun run(params: Params?) = when (params) {
        null -> throw MissingParamsException()
        else -> repository.searchPokedex(params.limit, params.offset)
    }

    data class Params(
        val limit: Int,
        val offset: Int
    )
}