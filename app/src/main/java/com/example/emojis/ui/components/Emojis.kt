package com.example.emojis.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.emojis.model.Emoji
import com.example.emojis.model.EmojiCollection
import com.example.emojis.ui.theme.EmojisAppTheme

@Composable
fun EmojiCollection(
    emojiCollection: EmojiCollection,
    onEmojiClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .heightIn(min = 56.dp)
                .padding(start = 24.dp)
        ) {
            Text(
                text = emojiCollection.name,
                style = MaterialTheme.typography.h6,
                color = EmojisAppTheme.colors.brand,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start)
            )
        }
        Emojis(emojiCollection.emojis, onEmojiClick)
    }
}

@Composable
private fun Emojis(
    emojis: List<Emoji>,
    onEmojiClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(start = 12.dp, end = 12.dp)
    ) {
        items(emojis) { snack ->
            EmojiItem(snack, onEmojiClick)
        }
    }
}

@Composable
fun EmojiItem(
    emoji: Emoji,
    onEmojiClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    EmojiAppSurface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.padding(
            start = 4.dp,
            end = 4.dp,
            bottom = 8.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable(onClick = { onEmojiClick(emoji.id) })
                .padding(8.dp)
        ) {
            EmojiImage(
                imageUrl = emoji.imageUrl,
                elevation = 4.dp,
                modifier = Modifier.size(120.dp)
            )
            Text(
                text = emoji.name,
                style = MaterialTheme.typography.subtitle1,
                color = EmojisAppTheme.colors.textSecondary,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun EmojiImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    EmojiAppSurface(
        color = Color.LightGray,
        elevation = elevation,
        shape = CircleShape,
        modifier = modifier
    ) {
        Image(
            painter = rememberImagePainter(
                data = imageUrl,
            ),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
    }
}
