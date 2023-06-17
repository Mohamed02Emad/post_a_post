package com.example.postapost.data.models

import androidx.annotation.Keep


@Keep
data class PostResponse(
    val id: Int,
    val userId: String
)