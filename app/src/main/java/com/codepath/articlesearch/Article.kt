package com.codepath.articlesearch


import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

//https://developer.android.com/reference/kotlin/androidx/annotation/Keep
@Keep
@Serializable
// It will map to the top level key "response" that we see in the JSON.
data class SearchNewsResponse(
    @SerialName("response")
    val response: BaseResponse?
)

@Keep
@Serializable
//This will map to the base response, which will include the array of documents (articles).
// Each array element will be an individual article.
data class BaseResponse(
    @SerialName("docs")
    val docs: List<Article>?
)

@Keep
@Serializable
data class Article(
    @SerialName("abstract")
    val abstract : String?,

    //Since all of these below are either JSON objects or nested JSON
    // they are typed to their own class, defined below
    @SerialName("byline")
    val byline: Byline?,

    @SerialName("headline")
    val headline: Headline?,

    @SerialName("multimedia")
    val multimedia: List<MultiMedia>?,
    )

    : java.io.Serializable {
    //TODO: find out what this line means v
    //This will use the first media in the array, if it's available
    // (by checking using firstOrNull), and parse through the MultiMedia
    // to get the url for the image.
    // If it is not available, it will set an empty string for the mediaImageUrl.
    val mediaImageUrl = "https://www.nytimes.com/${multimedia?.firstOrNull { it.url != null }?.url ?: ""}"
}

//Need to create classes below bc all of them all either nested JSON or list of JSON Objects
//Then the objects needed from that nested JSON are selected for in each class
@Keep
@Serializable
data class Headline(
    @SerialName("main")
    val main : String?
) : java.io.Serializable


@Keep
@Serializable
data class Byline(
    @SerialName("original")
    val original : String?
) : java.io.Serializable


@Keep
@Serializable
data class MultiMedia(
    @SerialName("url")
    val url: String?
) : java.io.Serializable





