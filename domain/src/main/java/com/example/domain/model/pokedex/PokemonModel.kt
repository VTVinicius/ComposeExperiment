package com.example.domain.model.pokedex

import com.example.data_remote.model.pokemon.*

data class PokemonModel(
    val abilities: List<AbilityModel>,
    val base_experience: Int,
    val formModels: List<FormModel>,
    val game_indices: List<GameIndiceModel>,
    val height: Int,
    val held_items: List<HeldItemModel>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moveModels: List<MoveModel>,
    val name: String,
    val order: Int,
    val past_types: List<Any>,
    val speciesModel: SpeciesModel,
    val spritesModel: SpritesModel,
    val statModels: List<StatModel>,
    val typeModels: List<TypeModel>,
    val weight: Int
)
