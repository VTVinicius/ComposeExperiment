package com.example.domain.model.pokedex

import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("name")
    val url: String? = ""
)