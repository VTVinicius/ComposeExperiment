package com.example.data_remote.service

import com.example.data_remote.model.pokedex.PokedexListResponse
import com.example.data_remote.model.pokemon.PokemonResponse
import com.example.data_remote.service.PokemonConstants.POKEDEX_POKEMONS
import com.example.data_remote.service.PokemonConstants.POKEMON_NAME
import com.example.data_remote.service.PokemonConstants.SPECIFIC_POKEON
import com.example.data_remote.utils.POKEDEX_BASE_URL
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokedexWebService {

    @GET(POKEDEX_POKEMONS)
    suspend fun searchPokedex(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokedexListResponse

    @GET(SPECIFIC_POKEON)
    suspend fun getPokemon(
        @Path(POKEMON_NAME) pokemonName: String
    ): PokemonResponse


}

object PokemonConstants {
    const val POKEMON_NAME = "pokemon"
    const val POKEDEX_POKEMONS = "$POKEDEX_BASE_URL/pokemon"
    const val SPECIFIC_POKEON = "$POKEDEX_POKEMONS/{$POKEMON_NAME}"

}