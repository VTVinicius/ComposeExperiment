package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class GameIndice(
    @SerializedName("game_index")
    val game_index: Int,
    @SerializedName("version")
    val version: Version
)