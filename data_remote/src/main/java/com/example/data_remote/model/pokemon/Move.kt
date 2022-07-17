package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class Move(
    @SerializedName("move")
    val move: MoveX,
    @SerializedName("version_group_details")
    val version_group_details: List<VersionGroupDetail>
)