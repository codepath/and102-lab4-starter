package com.codepath.articlesearch

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.codepath.articlesearch.databinding.ActivityDetailBinding

private const val TAG = "DetailActivity"

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var mediaIV: ImageView
    private lateinit var titleTV: TextView
    private lateinit var bylineTV: TextView
    private lateinit var abstractTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        binding.apply {
            mediaIV = mediaImage
            titleTV = mediaTitle
            bylineTV = mediaByline
            abstractTV = mediaAbstract
        }

        // Get the extra from the Intent
        val article = intent.getSerializableExtra(ARTICLE_EXTRA) as DisplayArticle

        // Set the title, byline, and abstract information from the article
        titleTV.text = article.headline?.main
        bylineTV.text = article.byline?.original
        abstractTV.text = article.abstract

        // Load the media image
        Glide.with(this)
            .load(article.mediaImageUrl)
            .into(mediaIV)
    }
}