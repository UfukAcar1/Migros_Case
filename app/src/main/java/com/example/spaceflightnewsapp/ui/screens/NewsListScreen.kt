package com.example.spaceflightnewsapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.spaceflightnewsapp.model.Article
import com.example.spaceflightnewsapp.ui.navigation.Screen
import java.text.SimpleDateFormat
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsListScreen(
    articles: List<Article>,
    isLoading: Boolean,
    errorMessage: String?,
    onRefresh: () -> Unit,
    navController: NavController
) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    Text(
                        text = "Spaceflight News",
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            when {
                isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }
                errorMessage != null -> {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = "Error: $errorMessage", style = MaterialTheme.typography.bodyMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = onRefresh) {
                            Text(text = "Try Again")
                        }
                    }
                }
                else -> {
                    LazyColumn {
                        items(articles) { article ->
                            ArticleItem(
                                article = article,
                                onArticleClick = {
                                    navController.navigate(Screen.NewsDetailScreen.createRoute(article.id))
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ArticleItem(
    article: Article,
    onArticleClick: (Article) -> Unit
) {
    // Kalp emojisi için state
    var isFavorited by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onArticleClick(article) }
            .padding(16.dp)
    ) {
        Text(
            text = article.title,
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = article.summary,
            maxLines = 3,
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Published: ${formatDate(article.publishedAt)}",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Kalp emojisi
        Text(
            text = if (isFavorited) "❤️" else "🤍", // Kırmızı kalp
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier
                .clickable {
                    isFavorited = !isFavorited // Kalbi ters çevir
                }
                .padding(8.dp)
        )
    }
    HorizontalDivider() // Divider
}

// Tarih formatlama fonksiyonu
fun formatDate(dateString: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd MMMM yyyy, HH:mm", Locale.getDefault())
    val date = inputFormat.parse(dateString)
    return outputFormat.format(date!!)
}