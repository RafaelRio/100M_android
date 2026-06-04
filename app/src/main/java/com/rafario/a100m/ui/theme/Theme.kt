package com.rafario.a100m.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = OrangePastel300,
    onPrimary = Cocoa,
    primaryContainer = OrangePastel700,
    onPrimaryContainer = OrangePastel100,
    secondary = PeachPastel300,
    onSecondary = Cocoa,
    secondaryContainer = CocoaMuted,
    onSecondaryContainer = OrangePastel100,
    tertiary = OrangePastel200,
    onTertiary = Cocoa,
    background = Cocoa,
    onBackground = OrangePastel100,
    surface = CocoaSurface,
    onSurface = OrangePastel100,
    surfaceVariant = CocoaMuted,
    onSurfaceVariant = OrangePastel200,
    outline = WarmOutline
)

private val LightColorScheme = lightColorScheme(
    primary = OrangePastel500,
    onPrimary = OrangePastel50,
    primaryContainer = OrangePastel200,
    onPrimaryContainer = Cocoa,
    secondary = PeachPastel300,
    onSecondary = Cocoa,
    secondaryContainer = PeachPastel100,
    onSecondaryContainer = Cocoa,
    tertiary = OrangePastel400,
    onTertiary = Cocoa,
    background = OrangePastel50,
    onBackground = Cocoa,
    surface = CreamPastel,
    onSurface = Cocoa,
    surfaceVariant = OrangePastel100,
    onSurfaceVariant = CocoaMuted,
    outline = WarmOutline
)

@Composable
fun _100MTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
