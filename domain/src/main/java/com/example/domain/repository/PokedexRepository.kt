package com.example.domain.repository

import com.example.domain.model.pokedex.PokedexListModel
import com.example.domain.model.pokedex.PokemonModel
import kotlinx.coroutines.flow.Flow

interface PokedexRepository {


    fun searchPokedex(limit: Int, offset: Int): Flow<PokedexListModel>

    fun searchPokemon(name: String): Flow<PokemonModel>


}