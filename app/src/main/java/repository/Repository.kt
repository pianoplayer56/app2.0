package repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.data.Post

interface PostRepository {
    fun get(): LiveData<Post>
    fun like()
    fun repost()
}

class PostRepositoryImpl : PostRepository {
    private var post = Post(
        1,
        "Netology",
        "today at 19:10",
        10,
        679,
        1999
    )
    private val data = MutableLiveData(post)

    override fun get(): LiveData<Post> = data

    override fun like() {
        post = post.copy(isLiked = !post.isLiked)
        if (post.isLiked) post.likes++ else post.likes--
        data.value = post
    }

    override fun repost() {
        post.reposts++
        data.value = post
    }
}