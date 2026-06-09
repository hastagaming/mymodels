package com.mymodels.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF6D8EFF),
    onPrimary = Color(0xFF001A6E),
    primaryContainer = Color(0xFF002FA0),
    onPrimaryContainer = Color(0xFFDAE2FF),
    secondary = Color(0xFFBBC5EA),
    onSecondary = Color(0xFF253054),
    secondaryContainer = Color(0xFF3B476C),
    onSecondaryContainer = Color(0xFFD8E2FF),
    tertiary = Color(0xFFD9BBFF),
    onTertiary = Color(0xFF3B0082),
    tertiaryContainer = Color(0xFF5400B8),
    onTertiaryContainer = Color(0xFFEDDCFF),
    background = Color(0xFF101318),
    onBackground = Color(0xFFE1E2E9),
    surface = Color(0xFF101318),
    onSurface = Color(0xFFE1E2E9),
    surfaceVariant = Color(0xFF434753),
    onSurfaceVariant = Color(0xFFC3C6D4),
    outline = Color(0xFF8D909E),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF1546D0),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFDAE2FF),
    onPrimaryContainer = Color(0xFF001A6E),
    secondary = Color(0xFF535E82),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFD8E2FF),
    onSecondaryContainer = Color(0xFF0E1B3B),
    tertiary = Color(0xFF6E22C3),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFEDDCFF),
    onTertiaryContainer = Color(0xFF27006A),
    background = Color(0xFFFAF8FF),
    onBackground = Color(0xFF1A1B21),
    surface = Color(0xFFFAF8FF),
    onSurface = Color(0xFF1A1B21),
    surfaceVariant = Color(0xFFE2E2EC),
    onSurfaceVariant = Color(0xFF454654),
    outline = Color(0xFF767685),
    error = Color(0xFFBA1A1A),
    onError = Color(0xFFFFFFFF),
)

@Composable
fun MyModelsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}