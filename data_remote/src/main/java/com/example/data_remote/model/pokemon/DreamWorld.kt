package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class DreamWorld(
    @SerializedName("front_default")
    val front_default: String,
    @SerializedName("front_female")
    val front_female: Any
)