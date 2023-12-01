package com.pr7.jc_retrofit_mvvm_clean_architecture.data.repositoryimpl

import com.pr7.jc_retrofit_mvvm_clean_architecture.data.model.remote.response.Post
import com.pr7.jc_retrofit_mvvm_clean_architecture.data.source.remote.Api
import com.pr7.jc_retrofit_mvvm_clean_architecture.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    val api: Api
):PostRepository {

    override suspend fun getAllPosts():Result<List<Post>> {
        try {
            val response=api.getAllPosts()
            return if (response.isSuccessful){
                Result.success(response.body()!!)
            }else{
                Result.failure(Exception(response.errorBody()?.string()))
            }
        }catch (e:Exception){
          return Result.failure(Exception(e.message))
        }

    }
}