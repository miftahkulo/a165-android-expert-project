package com.dicoding.tourismapp.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListTourismResponse(

	@field:SerializedName("places")
	val places: List<TourismResponse?>? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("message")
	val message: String? = null
)