package com.example.data.datasource.remote

import com.example.domain.model.pokedex.PokedexListModel
import com.example.domain.model.pokedex.PokemonModel
import kotlinx.coroutines.flow.Flow

interface PokedexRemoteDataSource {

    fun searchPokedex(limit: Int, offset: Int): Flow<PokedexListModel>

    fun searchPokemon(name: String): Flow<PokemonModel>

}