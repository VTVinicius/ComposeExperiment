package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class Platinum(
    @SerializedName("back_default")
    val back_default: String,
    @SerializedName("back_female")
    val back_female: Any,
    @SerializedName("back_shiny")
    val back_shiny: String,
    @SerializedName("back_shiny_female")
    val back_shiny_female: Any,
    @SerializedName("front_default")
    val front_default: String,
    @SerializedName("front_female")
    val front_female: Any,
    @SerializedName("front_shiny")
    val front_shiny: String,
    @SerializedName("front_shiny_female")
    val front_shiny_female: Any
)