package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationIi(
    @SerializedName("crystal")
    val crystal: CrystalModel,
    @SerializedName("gold")
    val gold: GoldModel,
    @SerializedName("silver")
    val silver: SilverModel
)