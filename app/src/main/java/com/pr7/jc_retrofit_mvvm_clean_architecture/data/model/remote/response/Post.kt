package com.pr7.jc_retrofit_mvvm_clean_architecture.data.model.remote.response

data class Post(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)