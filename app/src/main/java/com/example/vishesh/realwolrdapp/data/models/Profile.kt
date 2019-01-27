package com.example.vishesh.realwolrdapp.data.models

import com.google.gson.annotations.SerializedName

data class Profile(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("following")
	val following: Boolean? = null,

	@field:SerializedName("bio")
	val bio: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)