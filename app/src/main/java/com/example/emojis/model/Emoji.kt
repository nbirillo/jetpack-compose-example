package com.example.emojis.model

import androidx.compose.runtime.Immutable

@Immutable
data class Emoji(
    val id: Long,
    val name: String,
    val imageUrl: String,
    val description: String = "",
)

val emojis = listOf(
    Emoji(
        id = 1L,
        name = "Kissing",
        description = "A yellow face winking with puckered lips blowing a kiss, depicted as a small, red heart. May represent a kiss goodbye or good night and convey feelings of love and affection more generally.",
        imageUrl = "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/240/apple/285/face-blowing-a-kiss_1f618.png",
    ),
    Emoji(
        id = 2L,
        name = "Quiet",
        description = "A yellow face placing an index finger over pursed lips, as if issuing Shh! or Shush! for silence. Some platforms feature raised eyebrows. Apple’s design suggests the face is tilting back slightly.",
        imageUrl = "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/240/apple/285/shushing-face_1f92b.png",
    ),
    Emoji(
        id = 3L,
        name = "Smiling",
        description = "A classic smiley. A yellow face with a modest smile, rosy cheeks, and soft, closed eyes. Many platforms, including Apple, feature relaxed eyebrows. Conveys a wide range of warm, positive feelings, including love, happiness, and gratitude.",
        imageUrl = "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/240/apple/285/smiling-face_263a-fe0f.png",
    ),
    Emoji(
        id = 4L,
        name = "Sick",
        description = "A yellow face with raised or furrowed eyebrows and a thermometer in its mouth. Often depicted with red cheeks, as if feverish. May be used to represent a hospital patient or person with a cold or flu.",
        imageUrl = "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/240/apple/285/face-with-thermometer_1f912.png",
    ),
    Emoji(
        id = 5L,
        name = "Dizzy Face",
        description = "A face showing a spiral eyes, commonly used to indicate dizziness, but may also represent hypnosis or other forms of disorientation.",
        imageUrl = "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/240/apple/285/face-with-spiral-eyes_1f635-200d-1f4ab.png",
    ),
    Emoji(
        id = 6L,
        name = "Nerdy",
        description = "A smiling yellow face with glasses, often with teeth showing, originally buck teeth on most platforms.",
        imageUrl = "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/240/apple/285/nerd-face_1f913.png",
    ),
    Emoji(
        id = 7L,
        name = "Nervous Face",
        description = "A face with open eyes and a small, open frown. Its eyebrows are furrowed, with a single bead of cold sweat dripping down, and its forehead is pale blue, as if experiencing a cold flash. Samsung's design shows upper teeth and tongue.",
        imageUrl = "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/240/apple/285/anxious-face-with-sweat_1f630.png",
    ),
    Emoji(
        id = 8L,
        name = "Sigh",
        description = "A face showing a visible breath of air being dispelled. Used to represent relief, exhaustion, or as a sigh of disappointment or displeasure.",
        imageUrl = "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/240/apple/285/face-exhaling_1f62e-200d-1f4a8.png",
    ),
    Emoji(
        id = 9L,
        name = "Thinker",
        description = "A yellow face with furrowed eyebrows looking upwards with thumb and index finger resting on its chin. Intended to show a person pondering or deep in thought. Often used to question or scorn something or someone, as if saying Hmm, I don't know about that. Tone varies, including earnest, playful, puzzled, skeptical, and mocking.",
        imageUrl = "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/240/apple/285/thinking-face_1f914.png",
    ),
    Emoji(
        id = 10L,
        name = "In Love Face",
        description = "A yellow face with smiling eyes, a closed smile, rosy cheeks, and several hearts floating around its head. Expresses a range of happy, affectionate feelings, especially being in love. The number of hearts (three or more) varies by platform.",
        imageUrl = "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/240/apple/285/smiling-face-with-hearts_1f970.png",
    ),
)
