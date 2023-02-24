package com.example.hotel.domain.model.reviewsModel

import com.google.gson.annotations.SerializedName

data class ResponseReviewsItem(

	@field:SerializedName("city")
	val city: String? = null,
	@field:SerializedName("name")
	val name: String? = null,
	@field:SerializedName("id")
	val id: String? = null,
	@field:SerializedName("descript")
	val descript: String? = null
)