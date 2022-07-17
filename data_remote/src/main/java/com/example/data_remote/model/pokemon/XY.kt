package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class XY(
    @SerializedName("front_default")
    val front_default: String,
    @SerializedName("front_female")
    val front_female: Any,
    @SerializedName("front_shiny")
    val front_shiny: String,
    @SerializedName("front_shiny_female")
    val front_shiny_female: Any
)