package com.example.vishesh.realwolrdapp.data

import retrofit2.Call
import retrofit2.http.GET

interface ConduitInterfaceApi {
    @GET("articles")
    fun getArticles():Call<ArticleArrayResponse>
}