package com.pr7.jc_retrofit_mvvm_clean_architecture.domain.usacases

import com.pr7.jc_retrofit_mvvm_clean_architecture.data.model.remote.response.Post
import com.pr7.jc_retrofit_mvvm_clean_architecture.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class GetAllPostsUsaCase @Inject constructor(
    val postRepository: PostRepository
) {

    suspend fun getAllPosts(): Result<List<Post>> {
        return postRepository.getAllPosts()
    }
}