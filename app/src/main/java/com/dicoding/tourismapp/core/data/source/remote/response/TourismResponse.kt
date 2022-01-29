package com.dicoding.tourismapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TourismResponse(
    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("like")
    val like: Int? = null,

    @field:SerializedName("latitude")
    val latitude: Double? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("longitude")
    val longitude: Double? = null
)

