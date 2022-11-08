package com.example.firstandroidapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.firstandroidapp.databinding.ActivityMainBinding
import ru.netology.viewmodel.PostViewModel
import ru.netology.viewmodel.getRightNumber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                likesNumber.text = getRightNumber(post.likes)
                repostsNumber.text = getRightNumber(post.reposts)
                viewsNumber.text = getRightNumber(post.views)

                like.setImageResource(
                    if (post.isLiked) R.drawable.liked else R.drawable.like
                )
            }


            with(binding) {
                like.setOnClickListener {
                    viewModel.like()
                }

                reposts.setOnClickListener {
                    viewModel.repost()
                }
            }
        }
    }
}