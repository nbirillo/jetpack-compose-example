package com.example.emojis.ui

import android.content.res.Resources
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val EMOJI_DETAIL_ROUTE = "emoji"
    const val EMOJI_ID_KEY = "emojiId"
}

@Composable
fun rememberEmojiAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    resources: Resources = resources(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) =
    remember(scaffoldState, navController, resources, coroutineScope) {
        EmojiAppState(scaffoldState, navController)
    }

@Stable
class EmojiAppState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
) {
    fun upPress() = navController.navigateUp()

    fun navigateToEmojiDetail(emojiId: Long, from: NavBackStackEntry) {
        if (from.lifecycle.currentState == Lifecycle.State.RESUMED) {
            navController.navigate("${MainDestinations.EMOJI_DETAIL_ROUTE}/$emojiId")
        }
    }
}

@Composable
@ReadOnlyComposable
private fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}
