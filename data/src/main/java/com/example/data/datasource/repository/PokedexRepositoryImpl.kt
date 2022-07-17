package com.example.data.datasource.repository

import com.example.data.datasource.remote.PokedexRemoteDataSource
import com.example.domain.repository.PokedexRepository

class PokedexRepositoryImpl(
    private val pokedexRemoteDataSource: PokedexRemoteDataSource,
//    private val pokedexLocalDataSource: PokedexLocalDataSource
) : PokedexRepository {

    //Remote
    override fun searchPokedex(limit: Int, offset: Int) =
        pokedexRemoteDataSource.searchPokedex(limit, offset)

    override fun searchPokemon(name: String) =
        pokedexRemoteDataSource.searchPokemon(name)


    //Local

    //ADICIONAR AQUI LOCAL

}



