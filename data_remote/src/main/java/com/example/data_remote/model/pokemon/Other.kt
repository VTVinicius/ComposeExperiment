package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("dream_world")
    val dream_world: DreamWorld,
    @SerializedName("home")
    val home: Home,
    @SerializedName("official-artwork")
    val official_artwork: OfficialArtwork
)