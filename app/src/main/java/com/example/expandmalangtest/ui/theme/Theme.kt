package com.example.expandmalangtest.ui.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF2D6A4F),
    secondary = Color(0xFF52B788),
    tertiary = Color(0xFFB7E4C7),
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color(0xFF1B4332),
    onSurface = Color(0xFF1B4332)
)

// Paksa Dark Mode tetap menggunakan warna putih agar konsisten
private val DarkColorScheme = LightColorScheme

@Composable
fun ExpandMalangTestTheme(
    darkTheme: Boolean = false, // Default ke false untuk mematikan mode gelap
    dynamicColor: Boolean = false, // Matikan dynamic color agar tidak berubah warna sesuai wallpaper
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.White.toArgb()
            window.navigationBarColor = Color.White.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = true
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
