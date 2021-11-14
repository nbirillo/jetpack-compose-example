package com.example.emojis.ui.home

import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.addHomeGraph(
    onEmojiSelected: (Long, NavBackStackEntry) -> Unit,
    modifier: Modifier = Modifier
) {
    composable(HomeSections.FEED.route) { from ->
        Feed(onEmojiClick = { id -> onEmojiSelected(id, from) }, modifier)
    }
}

enum class HomeSections(
    val route: String
) {
    FEED("home/feed"),
}
