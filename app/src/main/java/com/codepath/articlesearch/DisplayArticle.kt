package com.codepath.articlesearch

import java.io.Serializable

data class DisplayArticle(
    val headline: String?,
    val abstract: String?,
    val byline: String?,
    val mediaImageUrl: String?
) : java.io.Serializable