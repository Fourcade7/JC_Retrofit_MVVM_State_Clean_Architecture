package com.pr7.jc_retrofit_mvvm_clean_architecture.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.GsonBuilder
import com.pr7.jc_retrofit_mvvm_clean_architecture.data.model.remote.response.Post
import com.pr7.jc_retrofit_mvvm_clean_architecture.domain.usacases.GetAllPostsUsaCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    val postsUsaCase: GetAllPostsUsaCase
):ViewModel() {

    var mutableStateflow:List<Post> by mutableStateOf(listOf())
    var errorStateflow:String by mutableStateOf("")


    fun getAllPosts()=viewModelScope.launch{
        postsUsaCase.getAllPosts().onSuccess {
            mutableStateflow=it
        }
        postsUsaCase.getAllPosts().onFailure {
            try {
                val gson = GsonBuilder().create()
                val gsonparse: Post= gson.fromJson(it.message, Post::class.java)
                //gsonparse.body error code
            } catch (e: Exception) {}
            errorStateflow=it.message.toString()
        }

    }

}