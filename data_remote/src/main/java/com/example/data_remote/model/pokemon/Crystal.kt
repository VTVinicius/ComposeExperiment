package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class Crystal(
    @SerializedName("back_default")
    val back_default: String,
    @SerializedName("back_shiny")
    val back_shiny: String,
    @SerializedName("back_shiny_transparent")
    val back_shiny_transparent: String,
    @SerializedName("back_transparent")
    val back_transparent: String,
    @SerializedName("front_default")
    val front_default: String,
    @SerializedName("front_shiny")
    val front_shiny: String,
    @SerializedName("front_shiny_transparent")
    val front_shiny_transparent: String,
    @SerializedName("front_transparent")
    val front_transparent: String
)