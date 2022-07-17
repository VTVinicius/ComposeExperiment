package com.example.data_remote.datasource

import com.example.data.datasource.remote.PokedexRemoteDataSource
import com.example.data_remote.mapper.pokedex.SearchPokedexMapper
import com.example.data_remote.mapper.pokedex.SearchPokemonMapper
import com.example.data_remote.service.PokedexWebService
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent

class PokedexRemoteDataSourceImpl(
    private val webService: PokedexWebService
) : PokedexRemoteDataSource, KoinComponent {


    override fun searchPokedex(limit: Int, offset: Int) = flow {
        emit(
            SearchPokedexMapper.toDomain(
                webService.searchPokedex(limit, offset)
            )
        )
    }
    override fun searchPokemon(name: String) = flow {
        emit(
            SearchPokemonMapper.toDomain(
                webService.getPokemon(name)
            )
        )
    }

}
