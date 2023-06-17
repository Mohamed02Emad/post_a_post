package com.example.postapost.data.models

import androidx.annotation.Keep

@Keep
data class GetPostResponse(
    val limit: Int,
    val posts: List<Post>,
    val skip: Int,
    val total: Int
)