package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationV(
    @SerializedName("black-white")
    val black_white: BlackWhiteModel
)