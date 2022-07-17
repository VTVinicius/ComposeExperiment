package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class VersionGroupDetail(
    @SerializedName("level_learned_at")
    val level_learned_at: Int,
    @SerializedName("move_learn_method")
    val move_learn_method: MoveLearnMethodModel,
    @SerializedName("version_group")
    val version_group: VersionGroupModel
)