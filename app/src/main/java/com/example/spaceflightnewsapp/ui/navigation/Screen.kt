package com.example.spaceflightnewsapp.ui.navigation

sealed class Screen(val route: String) {
    object NewsListScreen : Screen("news_list_screen")
    object NewsDetailScreen : Screen("news_detail_screen/{articleId}") {
        fun createRoute(articleId: Int) = "news_detail_screen/$articleId"
    }
}