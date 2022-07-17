package com.example.data_remote.model.pokedex

import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)