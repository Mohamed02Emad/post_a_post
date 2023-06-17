package com.example.postapost.data.api

import com.example.postapost.data.models.GetPostResponse
import com.example.postapost.globalUse.ALL_POSTS
import com.example.postapost.globalUse.BASE_URL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PostsAPI {

    //the documentation to get the parameters  https://newsapi.org/docs
    // i have an api key in a git ignored file

    @GET(ALL_POSTS)
    suspend fun getAllPosts(
    ): Response<GetPostResponse>


}