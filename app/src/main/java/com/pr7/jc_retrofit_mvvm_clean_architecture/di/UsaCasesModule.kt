package com.pr7.jc_retrofit_mvvm_clean_architecture.di

import com.pr7.jc_retrofit_mvvm_clean_architecture.domain.repository.PostRepository
import com.pr7.jc_retrofit_mvvm_clean_architecture.domain.usacases.GetAllPostsUsaCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class UsaCasesModule {


    @Provides
    fun provideGetAllpostUseCase(postRepository: PostRepository):GetAllPostsUsaCase= GetAllPostsUsaCase(postRepository)

}