package com.example.postapost.presentaion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.postapost.data.models.Post
import com.example.postapost.data.repositories.PostsRepository
import com.example.postapost.globalUse.isInternetAvailable
import com.example.postapost.globalUse.logIt
import com.example.postapost.globalUse.showToast
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: PostsRepository,
) : ViewModel() {

//    private val _posts: MutableLiveData<RequestState<GetPostResponse>> = MutableLiveData()
//    val posts: LiveData<RequestState<GetPostResponse>> = _posts
//    var postsResponse: GetPostResponse? = null


    private val _posts: MutableLiveData<ArrayList<Post>> = MutableLiveData()
    val posts: LiveData<ArrayList<Post>> = _posts
    var postsResponse: ArrayList<Post>? = null


    init {
        if (isInternetAvailable(repository.context))
            getAllPosts()
    }

    fun getAllPosts() = viewModelScope.launch {
        //_posts.postValue(RequestState.Loading())
        val response = repository.getFakePosts()
        _posts.postValue(response)
    }


//    private fun handleBreakingNewsResponse(response: Response<GetPostResponse>): RequestState<GetPostResponse> {
//        if (response.isSuccessful) {
//            response.body()?.let { result ->
//                if (postsResponse == null) {
//                    postsResponse = result
//                } else {
//                    val oldArticles = postsResponse?.posts
//                    val newArticles = result.posts
//                    oldArticles?.addAll(newArticles)
//                }
//                return RequestState.Sucess(postsResponse ?: result)
//            }
//        }
//        return RequestState.Error(response.message())
//    }


}