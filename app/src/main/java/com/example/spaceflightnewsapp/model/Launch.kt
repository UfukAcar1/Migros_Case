package com.example.spaceflightnewsapp.model

import com.google.gson.annotations.SerializedName

data class Launch(
    @SerializedName("launch_id") val launchId: String,
    val provider: String
)