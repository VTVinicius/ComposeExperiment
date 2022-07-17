package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationVii(
    @SerializedName("icons")
    val icons: IconsModel,
    @SerializedName("ultra-sun-ultra-moon")
    val ultra_sun_ultra_moon: UltraSunUltraMoonModel
)