package com.example.data_remote.mapper.pokedex

import com.example.data_remote.mapper.DataRemoteMapper
import com.example.data_remote.model.pokedex.PokedexListResponse
import com.example.domain.model.pokedex.PokedexListModel

object SearchPokedexMapper : DataRemoteMapper<PokedexListResponse, PokedexListModel>() {
    override fun toDomain(data: PokedexListResponse) = PokedexListModel(
        count = data.count,
        next = data.next,
        previous = data.previous,
        results = data.results
    )
}