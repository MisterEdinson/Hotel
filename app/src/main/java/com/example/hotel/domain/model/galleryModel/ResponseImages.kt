package com.example.hotel.domain.model.galleryModel

import java.io.Serializable

data class ResponseImages(
	val images: List<String?>? = null,
	val id: String? = null
): Serializable
