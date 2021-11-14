package com.example.emojis.ui.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.emojis.model.EmojiCollection
import com.example.emojis.model.EmojiRepo
import com.example.emojis.ui.components.EmojiAppSurface
import com.example.emojis.ui.components.EmojiCollection

@Composable
fun Feed(
    onEmojiClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val emojiCollections = remember { EmojiRepo.getEmojis() }
    Feed(
        emojiCollections,
        onEmojiClick,
        modifier
    )
}

@Composable
private fun Feed(
    emojiCollections: List<EmojiCollection>,
    onEmojiClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    EmojiAppSurface(modifier = modifier.fillMaxSize()) {
        Box {
            EmojiCollectionList(emojiCollections, onEmojiClick)
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun EmojiCollectionList(
    emojiCollections: List<EmojiCollection>,
    onEmojiClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier) {
        LazyColumn {
            itemsIndexed(emojiCollections) { _, emojiCollection ->
                EmojiCollection(
                    emojiCollection = emojiCollection,
                    onEmojiClick = onEmojiClick,
                )
            }
        }
    }
}
