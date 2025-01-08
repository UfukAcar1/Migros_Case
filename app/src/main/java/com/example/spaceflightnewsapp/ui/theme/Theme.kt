package com.example.spaceflightnewsapp.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val DarkColors = darkColorScheme(
    primary = Color(0xFFBB86FC),
    secondary = Color(0xFF03DAC5),
    onPrimary = Color.Black,
    background = Color(0xFF121212)
)

private val LightColors = lightColorScheme(
    primary = Color(0xFF6200EE),
    secondary = Color(0xFF03DAC5),
    onPrimary = Color.White,
    background = Color(0xFFFFFFFF)
)

@Composable
fun SpaceflightNewsTheme(
    darkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        shapes = MaterialTheme.shapes,
        content = {
            Column {
                AppBarWithTitle() // AppBarWithTitle kullanıyoruz ama başlık kısmı boş
                content()
            }
        }
    )
}

@Composable
fun AppBarWithTitle() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(0.dp), // Bu şekilde yükseklik sıfırlanır ve görünmez olur
        color = Color.Transparent // Rengi de şeffaf yapıyoruz
    ) {
        // No context
    }
}