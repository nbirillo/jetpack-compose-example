package com.example.emojis.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.SnackbarHost
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.emojis.ui.components.EmojiAppScaffold
import com.example.emojis.ui.components.EmojiAppSnackbar
import com.example.emojis.ui.home.HomeSections
import com.example.emojis.ui.home.addHomeGraph
import com.example.emojis.ui.snackdetail.EmojiDetail
import com.example.emojis.ui.theme.EmojisAppTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.systemBarsPadding

@Composable
fun EmojiApp() {
    ProvideWindowInsets {
        EmojisAppTheme {
            val appState = rememberEmojiAppState()
            EmojiAppScaffold(
                snackbarHost = {
                    SnackbarHost(
                        hostState = it,
                        modifier = Modifier.systemBarsPadding(),
                        snackbar = { snackbarData -> EmojiAppSnackbar(snackbarData) }
                    )
                },
                scaffoldState = appState.scaffoldState
            ) { innerPaddingModifier ->
                NavHost(
                    navController = appState.navController,
                    startDestination = MainDestinations.HOME_ROUTE,
                    modifier = Modifier.padding(innerPaddingModifier)
                ) {
                    emojiNavGraph(
                        onSnackSelected = appState::navigateToEmojiDetail,
                        upPress = appState::upPress
                    )
                }
            }
        }
    }
}

private fun NavGraphBuilder.emojiNavGraph(
    onSnackSelected: (Long, NavBackStackEntry) -> Unit,
    upPress: () -> Unit
) {
    navigation(
        route = MainDestinations.HOME_ROUTE,
        startDestination = HomeSections.FEED.route
    ) {
        addHomeGraph(onSnackSelected)
    }
    composable(
        "${MainDestinations.EMOJI_DETAIL_ROUTE}/{${MainDestinations.EMOJI_ID_KEY}}",
        arguments = listOf(navArgument(MainDestinations.EMOJI_ID_KEY) { type = NavType.LongType })
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val emojiId = arguments.getLong(MainDestinations.EMOJI_ID_KEY)
        EmojiDetail(emojiId, upPress)
    }
}
