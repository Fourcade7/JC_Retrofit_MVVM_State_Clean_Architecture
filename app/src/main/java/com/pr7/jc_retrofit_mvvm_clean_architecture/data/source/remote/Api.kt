package com.pr7.jc_retrofit_mvvm_clean_architecture.data.source.remote

import com.pr7.jc_retrofit_mvvm_clean_architecture.data.model.remote.response.Post
import retrofit2.Response
import retrofit2.http.GET

interface Api {


    @GET("posts")
    suspend  fun getAllPosts():Response<List<Post>>
}