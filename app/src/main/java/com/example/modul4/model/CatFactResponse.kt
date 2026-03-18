package com.example.modul4.model

import com.google.gson.annotations.SerializedName

data class CatFactResponse(
    @SerializedName(value = "fact") val fact: String,
    @SerializedName(value = "length") val length: Int
)
