package com.example.emojis.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.emojis.ui.theme.EmojisAppTheme

// A wrapper to use our custom app theme
@Composable
fun EmojiAppSurface(
    modifier: Modifier = Modifier,
    shape: Shape = RectangleShape,
    color: Color = EmojisAppTheme.colors.uiBackground,
    contentColor: Color = EmojisAppTheme.colors.textSecondary,
    elevation: Dp = 0.dp,
    content: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .shadow(elevation = elevation, shape = shape, clip = false)
            .zIndex(elevation.value)
            .then(Modifier)
            .background(
                color = color,
                shape = shape
            )
            .clip(shape)
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor, content = content)
    }
}
