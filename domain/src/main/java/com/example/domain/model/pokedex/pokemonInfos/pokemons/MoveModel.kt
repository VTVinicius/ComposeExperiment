package com.example.data_remote.model.pokemon

data class MoveModel(
    val move: MoveXModel,
    val version_group_details: List<VersionGroupDetailModel>
)