package com.example.postapost.presentaion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postapost.data.api.RequestState
import com.example.postapost.data.models.GetPostResponse
import com.example.postapost.data.repositories.PostsRepository
import com.example.postapost.globalUse.isInternetAvailable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: PostsRepository,
) : ViewModel() {

    private val _posts: MutableLiveData<RequestState<GetPostResponse>> = MutableLiveData()
    val posts: LiveData<RequestState<GetPostResponse>> = _posts
    var postsResponse: GetPostResponse? = null


//    private val _posts: MutableLiveData<ArrayList<Post>> = MutableLiveData()
//    val posts: LiveData<ArrayList<Post>> = _posts
//    var postsResponse: ArrayList<Post>? = null


    init {
        if (isInternetAvailable(repository.context))
            getAllPosts()
    }

    fun getAllPosts() = viewModelScope.launch {
        val response = repository.getAllPosts()
        _posts.postValue(handleBreakingNewsResponse(response))
    }


    private fun handleBreakingNewsResponse(response: Response<GetPostResponse>): RequestState<GetPostResponse> {
        if (response.isSuccessful) {
            response.body()?.let { result ->
                if (postsResponse == null) {
                    postsResponse = result
                } else {
                    val oldArticles = postsResponse?.posts
                    val newArticles = result.posts
                    oldArticles?.addAll(newArticles)
                }
                return RequestState.Sucess(postsResponse ?: result)
            }
        }
        return RequestState.Error(response.message())
    }


}