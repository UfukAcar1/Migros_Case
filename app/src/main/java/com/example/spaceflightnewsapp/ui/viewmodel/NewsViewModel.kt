package com.example.spaceflightnewsapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spaceflightnewsapp.model.Article
import com.example.spaceflightnewsapp.repository.SpaceflightNewsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel(
    private val repository: SpaceflightNewsRepository = SpaceflightNewsRepository()
) : ViewModel() {

    private val _articles = MutableStateFlow<List<Article>>(emptyList())
    val articles: StateFlow<List<Article>> = _articles

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun fetchArticles(limit: Int, offset: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // PaginatedArticleList üzerinden makale listesini al
                val paginatedResult = repository.getPaginatedArticles(limit, offset)
                if (paginatedResult?.results != null) {
                    _articles.value = paginatedResult.results
                    _errorMessage.value = null
                } else {
                    _errorMessage.value = "Veri alınamadı."
                }
            } catch (e: Exception) {
                _errorMessage.value = "Hata: ${e.localizedMessage}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}