package ru.netology.data

data class Post(
    val id: Int,
    val author: String,
    val published: String,
    var likes: Int = 0,
    var reposts: Int = 0,
    var views: Int = 0,
    val isLiked: Boolean = false
)

