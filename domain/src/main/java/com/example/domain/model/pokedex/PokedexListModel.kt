package com.example.domain.model.pokedex

import com.google.gson.annotations.SerializedName

data class PokedexListModel(
    val count: Int? = 0,
    val next: String? = "",
    val previous: Any?,
    val results: List<ResultModel>?
)
