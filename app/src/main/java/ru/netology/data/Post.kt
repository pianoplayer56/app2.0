package ru.netology.data

data class Post(
    val id: Int,
    val author: String,
    val published: String,
    var likes: Int = 0,
    var reposts: Int = 0,
    var views: Int = 0,
    var isLiked: Boolean = false
)

fun getRightNumber(number: Int): String =
    when (number) {
        in (0..999) -> number.toString()
        in (1000..9999) -> String.format(
            "%.1f K",
            (number - number % 100) / 1000.0
        )
        in (10_000..999_999) -> "${number / 1000} K"
        in (1000000..Int.MAX_VALUE) -> String.format(
            "%.1f M",
            (number - number % 100_000) / 1_000_000.0
        )
        else -> throw RuntimeException()
    }