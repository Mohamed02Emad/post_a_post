package com.example.postapost.data.api

import com.example.postapost.data.models.GetPostResponse
import com.example.postapost.globalUse.ALL_POSTS
import com.example.postapost.globalUse.SEARCH_POST
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface PostsAPI {

    @GET(ALL_POSTS)
    suspend fun getAllPosts(
    ): Response<GetPostResponse>


    @GET
    suspend fun searchForPosts(
        @Url endpoint: String,
    ): Response<GetPostResponse>


}