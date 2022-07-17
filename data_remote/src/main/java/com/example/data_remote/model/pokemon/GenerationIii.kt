package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationIii(
    @SerializedName("emerald")
    val emerald: EmeraldModel,
    @SerializedName("firered-leafgreen")
    val firered_leafgreen: FireredLeafgreenModel,
    @SerializedName("ruby-sapphire")
    val ruby_sapphire: RubySapphireModel
)