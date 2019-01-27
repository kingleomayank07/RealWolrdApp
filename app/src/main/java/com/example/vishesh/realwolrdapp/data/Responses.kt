package com.example.vishesh.realwolrdapp.data

import com.example.vishesh.realwolrdapp.data.models.Article
import com.example.vishesh.realwolrdapp.data.models.Comment
import com.example.vishesh.realwolrdapp.data.models.Profile
import com.example.vishesh.realwolrdapp.data.models.User
import com.google.gson.annotations.SerializedName

data class ArticleResponse(

    @field:SerializedName("article")
    val article: Article
)
data class ArticleArrayResponse(
    @SerializedName("articles")
    var articles: ArrayList<Article>,
    @SerializedName("articlesCount")
    var articleCount:Int
)
data class ProfileResponse(

    @field:SerializedName("profile")
    val profile: Profile? = null
)
data class UserResponse(

    @field:SerializedName("user")
    val user: User? = null
)
data class CommentResponse(
    @SerializedName ("comments")
    var comments: Comment
)

data class CommentArrayResponse(
    @SerializedName ("comments")
    var comments:List<Comment>
)
