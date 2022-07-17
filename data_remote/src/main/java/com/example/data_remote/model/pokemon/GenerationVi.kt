package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    val omegaruby_alphasapphire: OmegarubyAlphasapphireModel,
    @SerializedName("x-y")
    val x_y: XYModel
)