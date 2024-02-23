package com.codepath.flixterplus

import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class BaseResponse(
    @SerialName("results")
    val results: List<Movie>?
)

@Keep
@Serializable
data class Movie(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("overview")
    val overview: String,
    @SerialName("poster_path")
    val posterPath: String?,
    @SerialName("backdrop_path")
    val backdropPath: String?
) : java.io.Serializable {
    val mediaImageUrl = "https://image.tmdb.org/t/p/original${posterPath ?: ""}"
}

@Keep
@Serializable
data class HeadLine(
    @SerialName("main")
    val main: String
) : java.io.Serializable

@Keep
@Serializable
data class Byline (
    @SerialName("original")
    val original: String? = null
) : java.io.Serializable

@Keep
@Serializable
data class MultiMedia(
    @SerialName("url")
    val url: String?
) : java.io.Serializable
