package com.hark.pokedex.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
// ---------- Light Theme ----------
val LightPrimary = Color(0xFFCC0000) // Red
val LightOnPrimary = Color.White
val LightPrimaryContainer = Color(0xFFFFD5D2)
val LightOnPrimaryContainer = Color(0xFF7F0000)

val LightSecondary = Color(0xFF1976D2) // Blue
val LightOnSecondary = Color.White
val LightSecondaryContainer = Color(0xFFE3F2FD)
val LightOnSecondaryContainer = Color(0xFF0D47A1)

val LightTertiary = Color(0xFF43A047) // Green
val LightOnTertiary = Color.White
val LightTertiaryContainer = Color(0xFFE8F5E9)
val LightOnTertiaryContainer = Color(0xFF1B5E20)

val LightError = Color(0xFFE57373)
val LightOnError = Color.White
val LightErrorContainer = Color(0xFFFFEBEE)
val LightOnErrorContainer = Color(0xFFB71C1C)

val LightBackground = Color(0xFFFFFFFF)
val LightOnBackground = Color(0xFF1A1A1A)
val LightSurface = Color(0xFFFFFFFF)
val LightOnSurface = Color(0xFF1A1A1A)
val LightSurfaceVariant = Color(0xFFF9F9F9)
val LightOnSurfaceVariant = Color(0xFF5C5C5C)


// ---------- Dark Theme ----------
val DarkPrimary = Color(0xFFF44033) // Red
val DarkOnPrimary = Color.Black
val DarkPrimaryContainer = Color(0xFFB71C1C)
val DarkOnPrimaryContainer = Color(0xFFFFCDD2)

val DarkSecondary = Color(0xFF42A5F5) // Blue
val DarkOnSecondary = Color.Black
val DarkSecondaryContainer = Color(0xFF0D47A1)
val DarkOnSecondaryContainer = Color(0xFFBBDEFB)

val DarkTertiary = Color(0xFF66BB6A) // Green
val DarkOnTertiary = Color(0xFF1B5E20)
val DarkTertiaryContainer = Color(0xFF2E7D32)
val DarkOnTertiaryContainer = Color(0xFFC8E6C9)

val DarkError = Color(0xFFEF5350)
val DarkOnError = Color(0xFFB71C1C)
val DarkErrorContainer = Color(0xFFC62828)
val DarkOnErrorContainer = Color(0xFFFFCDD2)

val DarkBackground = Color(0xFF121212)
val DarkOnBackground = Color(0xFFE0E0E0)
val DarkSurface = Color(0xFF1E1E1E)
val DarkOnSurface = Color(0xFFE0E0E0)
val DarkSurfaceVariant = Color(0xFF2C2C2C)
val DarkOnSurfaceVariant = Color(0xFFBDBDBD)




val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    primaryContainer = LightPrimaryContainer,
    onPrimaryContainer = LightOnPrimaryContainer,
    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    secondaryContainer = LightSecondaryContainer,
    onSecondaryContainer = LightOnSecondaryContainer,
    tertiary = LightTertiary,
    onTertiary = LightOnTertiary,
    tertiaryContainer = LightTertiaryContainer,
    onTertiaryContainer = LightOnTertiaryContainer,
    error = LightError,
    onError = LightOnError,
    errorContainer = LightErrorContainer,
    onErrorContainer = LightOnErrorContainer,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = Color(0xFF757575),
    outlineVariant = Color(0xFFBDBDBD),
)

val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = DarkPrimaryContainer,
    onPrimaryContainer = DarkOnPrimaryContainer,
    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    secondaryContainer = DarkSecondaryContainer,
    onSecondaryContainer = DarkOnSecondaryContainer,
    tertiary = DarkTertiary,
    onTertiary = DarkOnTertiary,
    tertiaryContainer = DarkTertiaryContainer,
    onTertiaryContainer = DarkOnTertiaryContainer,
    error = DarkError,
    onError = DarkOnError,
    errorContainer = DarkErrorContainer,
    onErrorContainer = DarkOnErrorContainer,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = Color(0xFF9E9E9E),
    outlineVariant = Color(0xFF424242),
)
