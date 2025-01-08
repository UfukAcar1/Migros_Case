package com.example.spaceflightnewsapp.repository

import com.example.spaceflightnewsapp.model.Article
import com.example.spaceflightnewsapp.model.PaginatedArticleList
import com.example.spaceflightnewsapp.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SpaceflightNewsRepository {

    // Sayfalama destekli makale listeleme
    suspend fun getPaginatedArticles(limit: Int, offset: Int): PaginatedArticleList? =
        withContext(Dispatchers.IO) {
            val response = RetrofitInstance.api.getArticles(limit, offset)
            if (response.isSuccessful) {
                response.body() // Başarılıysa PaginatedArticleList döner
            } else {
                throw Exception("API Hatası: ${response.errorBody()?.string()}") // Hata fırlatır
            }
        }

    // ID'ye göre makale alma
    suspend fun getArticleById(id: Int): Article? = withContext(Dispatchers.IO) {
        val response = RetrofitInstance.api.getArticleById(id)
        if (response.isSuccessful) {
            response.body() // Başarılıysa Article döner
        } else {
            throw Exception("Makale bulunamadı: ${response.errorBody()?.string()}") // Hata fırlatır
        }
    }
}