package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationIv(
    @SerializedName("diamond-pearl")
    val diamond_pearl: DiamondPearlModel,
    @SerializedName("heartgold-soulsilver")
    val heartgold_soulsilver: HeartgoldSoulsilverModel,
    @SerializedName("platinum")
    val platinum: PlatinumModel
)