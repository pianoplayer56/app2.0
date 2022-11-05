package com.example.firstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstandroidapp.databinding.ActivityMainBinding
import ru.netology.data.Post
import ru.netology.data.getRightNumber

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            1,
            "Netology",
            "today at 19:10",
            88889,
            679,
            1999
        )

        with(binding) {
            author.text = post.author
            published.text = post.published
            likesNumber.text = getRightNumber(post.likes)
            repostsNumber.text = getRightNumber(post.reposts)
            viewsNumber.text = getRightNumber(post.views)

            if (post.isLiked) {
                like.setImageResource(R.drawable.liked)
            }

            like.setOnClickListener {
                if (post.isLiked) post.likes-- else post.likes++
                post.isLiked = !post.isLiked
                like.setImageResource(
                    if (post.isLiked) R.drawable.liked else R.drawable.like
                )
                likesNumber.text = getRightNumber(post.likes)
            }

            reposts.setOnClickListener {
                post.reposts++
                repostsNumber.text = getRightNumber(post.reposts)
            }
        }
    }
}