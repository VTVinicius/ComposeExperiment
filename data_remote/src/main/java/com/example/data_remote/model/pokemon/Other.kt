package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("dream_world")
    val dream_world: DreamWorldModel,
    @SerializedName("home")
    val home: HomeModel,
    @SerializedName("official-artwork")
    val official_artwork: OfficialArtworkModel
)