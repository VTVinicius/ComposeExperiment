package com.example.data_remote.mapper.pokedex

import com.example.data_remote.mapper.DataRemoteMapper
import com.example.data_remote.model.pokemon.PokemonResponseModel
import com.example.domain.model.pokedex.PokemonModel

object SearchPokemonMapper : DataRemoteMapper<PokemonResponseModel, PokemonModel>() {
    override fun toDomain(data: PokemonResponseModel) = PokemonModel(
        abilities = data.abilities,
        base_experience = data.base_experience,
        formModels = data.formModels,
        game_indices = data.game_indices,
        height = data.height,
        held_items = data.held_items,
        id = data.id,
        is_default = data.is_default,
        location_area_encounters = data.location_area_encounters,
        moveModels = data.moveModels,
        name = data.name,
        order = data.order,
        past_types = data.past_types,
        speciesModel = data.speciesModel,
        spritesModel = data.spritesModel,
        statModels = data.statModels,
        typeModels = data.typeModels,
        weight = data.weight,
    )
}