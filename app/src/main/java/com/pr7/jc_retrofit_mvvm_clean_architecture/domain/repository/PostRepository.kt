package com.pr7.jc_retrofit_mvvm_clean_architecture.domain.repository

import com.pr7.jc_retrofit_mvvm_clean_architecture.data.model.remote.response.Post
import kotlinx.coroutines.flow.Flow
import retrofit2.Response


interface PostRepository {


   suspend fun getAllPosts():Result<List<Post>>
}