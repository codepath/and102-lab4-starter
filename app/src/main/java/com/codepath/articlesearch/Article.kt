package com.codepath.articlesearch

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class SearchNewsResponse(

    @SerialName("response")
    val response: BaseResponse?
)

@Keep
@Serializable
class BaseResponse (
    @SerialName("docs")
    val docs: List<Article>?)

@Keep
@Serializable
data class Article (
    @SerialName("abstract")
    val abstract: String?,

    @SerialName("headline")
    val headline: Headline?,

    @SerialName("multimedia")
    val multimedia: List<MultiMedia>?,

    @SerialName("byline")
    val byline: Byline?) : java.io.Serializable {
    val mediaImageUrl = "https://www.nytimes.com/${multimedia?.firstOrNull { it.url != null }?.url ?: ""}" }

@Keep
@Serializable
data class Headline (
    @SerialName("main")
    val main: String ) : java.io.Serializable

@Keep
@Serializable
data class Byline (
    @SerialName("original")
    val original: String? = null
    ) : java.io.Serializable

@Keep
@Serializable
data class MultiMedia (
    @SerialName("url")
    val url: String?
    ) : java.io.Serializable