package com.example.emojis.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.example.emojis.ui.theme.EmojisAppTheme

// A wrapper to use our custom app theme
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EmojiAppScaffold(
    modifier: Modifier = Modifier,
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    snackbarHost: @Composable (SnackbarHostState) -> Unit = { SnackbarHost(it) },
    drawerContent: @Composable (ColumnScope.() -> Unit)? = null,
    drawerShape: Shape = MaterialTheme.shapes.large,
    drawerElevation: Dp = DrawerDefaults.Elevation,
    drawerBackgroundColor: Color = EmojisAppTheme.colors.uiBackground,
    drawerContentColor: Color = EmojisAppTheme.colors.textSecondary,
    drawerScrimColor: Color = EmojisAppTheme.colors.uiBorder,
    backgroundColor: Color = EmojisAppTheme.colors.uiBackground,
    contentColor: Color = EmojisAppTheme.colors.textSecondary,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        snackbarHost = snackbarHost,
        drawerContent = drawerContent,
        drawerShape = drawerShape,
        drawerElevation = drawerElevation,
        drawerBackgroundColor = drawerBackgroundColor,
        drawerContentColor = drawerContentColor,
        drawerScrimColor = drawerScrimColor,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        content = content
    )
}
