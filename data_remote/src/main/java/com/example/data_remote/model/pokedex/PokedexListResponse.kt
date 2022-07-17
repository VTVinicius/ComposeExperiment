package com.example.data_remote.model.pokedex

import com.example.domain.model.pokedex.ResultModel
import com.google.gson.annotations.SerializedName

data class PokedexListResponse(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("results")
    val results: List<ResultModel>?
)