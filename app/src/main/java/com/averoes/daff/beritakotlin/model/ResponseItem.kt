package com.averoes.daff.beritakotlin.model

import com.google.gson.annotations.SerializedName

data class ResponseItem(

	@field:SerializedName("berita")
	val berita: List<BeritaItem?>? = null,

	@field:SerializedName("status")
	val status: Boolean? = null
)