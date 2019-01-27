package com.example.vishesh.realwolrdapp.data.models

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("image")
	val image: Any? = null,

	@field:SerializedName("bio")
	val bio: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("token")
	val token: String? = null,

	@field:SerializedName("username")
	val username: String? = null
)