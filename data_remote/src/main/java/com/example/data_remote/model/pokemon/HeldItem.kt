package com.example.data_remote.model.pokemon

import com.google.gson.annotations.SerializedName

data class HeldItem(
    @SerializedName("item")
    val item: ItemModel,
    @SerializedName("version_details")
    val version_details: List<VersionDetailModel>
)