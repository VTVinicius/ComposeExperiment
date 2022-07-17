package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("abilities")
    val abilities: List<Ability>,

    @SerializedName("base_experience")
    val base_experience: Int,

    @SerializedName("forms")
    val forms: List<Form>,

    @SerializedName("game_indices")
    val game_indices: List<GameIndice>,

    @SerializedName("height")
    val height: Int,

    @SerializedName("held_items")
    val held_items: List<HeldItem>,

    @SerializedName("id")
    val id: Int,

    @SerializedName("is_default")
    val is_default: Boolean,

    @SerializedName("location_area_encounters")
    val location_area_encounters: String,

    @SerializedName("moves")
    val moves: List<Move>,

    @SerializedName("name")
    val name: String,

    @SerializedName("order")
    val order: Int,

    @SerializedName("past_types")
    val past_types: List<Any>,

    @SerializedName("species")
    val species: Species,

    @SerializedName("sprites")
    val sprites: Sprites,

    @SerializedName("stats")
    val stats: List<Stat>,

    @SerializedName("types")
    val types: List<Type>,

    @SerializedName("weight")
    val weight: Int
)