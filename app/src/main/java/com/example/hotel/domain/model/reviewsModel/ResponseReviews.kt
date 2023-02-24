package com.example.hotel.domain.model.reviewsModel

import com.google.gson.annotations.SerializedName

data class ResponseReviews(
	@field:SerializedName("ResponseReviews")
	val responseReviews: List<ResponseReviewsItem?>? = null
)