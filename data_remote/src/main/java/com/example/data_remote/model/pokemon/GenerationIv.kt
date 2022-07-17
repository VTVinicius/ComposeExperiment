package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class GenerationIv(
    @SerializedName("diamond-pearl")
    val diamond_pearl: DiamondPearl,
    @SerializedName("heartgold-soulsilver")
    val heartgold_soulsilver: HeartgoldSoulsilver,
    @SerializedName("platinum")
    val platinum: Platinum
)