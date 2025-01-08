package com.example.spaceflightnewsapp.model

data class PaginatedArticleList(
    val count: Int?,
    val next: String?,
    val previous: String?,
    val results: List<Article>?
)