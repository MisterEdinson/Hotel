package com.example.hotel.domain.model.home

import com.google.gson.annotations.SerializedName

data class ResponseItem(
	@field:SerializedName("gen_img")
	val genImg: String? = null,
	@field:SerializedName("price_table")
	val priceTable: String? = null,
	val price: String? = null,
	val name: String? = null,
	val ydobstva: String? = null,
	@field:SerializedName("m_desc")
	val mDesc: String? = null,
	@field:SerializedName("b_desc")
	val bDesc: String? = null,
	val id: String? = null,
	val gallery: String? = null
)
