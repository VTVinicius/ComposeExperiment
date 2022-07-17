package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class OfficialArtwork(
    @SerializedName("front_default")
    val front_default: String
)