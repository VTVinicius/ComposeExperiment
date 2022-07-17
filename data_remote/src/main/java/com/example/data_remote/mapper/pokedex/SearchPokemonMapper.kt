package com.example.data_remote.mapper.pokedex

import com.example.data_remote.mapper.DataRemoteMapper
import com.example.data_remote.model.pokemon.PokemonResponse
import com.example.domain.model.pokedex.PokemonModel

object SearchPokemonMapper : DataRemoteMapper<PokemonResponse, PokemonModel>() {
    override fun toDomain(data: PokemonResponse) = PokemonModel(
        abilities = data.abilities,
        base_experience = data.base_experience,
        forms = data.forms,
        game_indices = data.game_indices,
        height = data.height,
        held_items = data.held_items,
        id = data.id,
        is_default = data.is_default,
        location_area_encounters = data.location_area_encounters,
        moves = data.moves,
        name = data.name,
        order = data.order,
        past_types = data.past_types,
        species = data.species,
        sprites = data.sprites,
        stats = data.stats,
        types = data.types,
        weight = data.weight,
    )
}