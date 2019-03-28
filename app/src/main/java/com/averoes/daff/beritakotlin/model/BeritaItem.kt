package com.averoes.daff.beritakotlin.model

import com.google.gson.annotations.SerializedName

data class BeritaItem(

	@field:SerializedName("penulis")
	val penulis: String? = null,

	@field:SerializedName("foto")
	val foto: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("judul_berita")
	val judulBerita: String? = null,

	@field:SerializedName("tanggal_posting")
	val tanggalPosting: String? = null,

	@field:SerializedName("isi_berita")
	val isiBerita: String? = null
)