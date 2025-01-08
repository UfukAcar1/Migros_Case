package com.example.spaceflightnewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spaceflightnewsapp.ui.navigation.Screen
import com.example.spaceflightnewsapp.ui.screens.NewsDetailScreen
import com.example.spaceflightnewsapp.ui.screens.NewsListScreen
import com.example.spaceflightnewsapp.ui.screens.SplashScreen
import com.example.spaceflightnewsapp.ui.theme.SpaceflightNewsTheme
import com.example.spaceflightnewsapp.ui.viewmodel.NewsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceflightNewsTheme {
                val navController = rememberNavController()
                val newsViewModel: NewsViewModel = viewModel()

                val articles by newsViewModel.articles.collectAsState()
                val isLoading by newsViewModel.isLoading.collectAsState()
                val errorMessage by newsViewModel.errorMessage.collectAsState()

                newsViewModel.fetchArticles(limit = 10, offset = 0)

                NavHost(
                    navController = navController,
                    startDestination = "splash_screen"
                ) {
                    composable("splash_screen") {
                        SplashScreen(navController = navController)
                    }
                    composable(Screen.NewsListScreen.route) {
                        NewsListScreen(
                            articles = articles,
                            isLoading = isLoading,
                            errorMessage = errorMessage,
                            onRefresh = { newsViewModel.fetchArticles(10, 0) },
                            navController = navController
                        )
                    }
                    composable(Screen.NewsDetailScreen.route) { backStackEntry ->
                        val articleIdString = backStackEntry.arguments?.getString("articleId") ?: "0"
                        val articleId = articleIdString.toIntOrNull() ?: 0

                        NewsDetailScreen(
                            articleId = articleId,
                            articles = articles,
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}