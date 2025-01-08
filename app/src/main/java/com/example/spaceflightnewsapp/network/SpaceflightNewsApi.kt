package com.example.spaceflightnewsapp.network

import com.example.spaceflightnewsapp.model.Article
import com.example.spaceflightnewsapp.model.PaginatedArticleList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SpaceflightNewsApi {

    @GET("articles/")
    suspend fun getArticles(
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): Response<PaginatedArticleList>

    @GET("articles/{id}/")
    suspend fun getArticleById(
        @Path("id") id: Int
    ): Response<Article>

    companion object {
        const val BASE_URL = "https://api.spaceflightnewsapi.net/v4/"
    }
}