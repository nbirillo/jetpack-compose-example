package com.example.emojis.model

import androidx.compose.runtime.Immutable

@Immutable
data class EmojiCollection(
    val id: Long,
    val name: String,
    val emojis: List<Emoji>,
)

object EmojiRepo {
    fun getEmojis(): List<EmojiCollection> = emojiCollections
    fun getEmoji(emojiId: Long) = emojis.find { it.id == emojiId }!!
}

private val appleEmojis = EmojiCollection(
    id = 1L,
    name = "Apple emojis",
    emojis = emojis
)

private val emojiCollections = listOf(
    appleEmojis,
)
