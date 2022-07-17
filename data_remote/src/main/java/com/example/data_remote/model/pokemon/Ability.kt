package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class Ability(
    @SerializedName("ability")
    val ability: AbilityXModel,
    @SerializedName("is_hidden")
    val is_hidden: Boolean,
    @SerializedName("slot")
    val slot: Int
)