package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class Versions(
    @SerializedName("generation-i")
    val generation_i: GenerationIModel,
    @SerializedName("generation-ii")
    val generation_ii: GenerationIiModel,
    @SerializedName("generation-iii")
    val generation_iii: GenerationIiiModel,
    @SerializedName("generation-iv")
    val generation_iv: GenerationIvModel,
    @SerializedName("generation-v")
    val generation_v: GenerationVModel,
    @SerializedName("generation-vi")
    val generation_vi: GenerationViModel,
    @SerializedName("generation-vii")
    val generation_vii: GenerationViiModel,
    @SerializedName("generation-viii")
    val generation_viii: GenerationViiiModel

)