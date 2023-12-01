package com.pr7.jc_retrofit_mvvm_clean_architecture.di

import com.pr7.jc_retrofit_mvvm_clean_architecture.data.repositoryimpl.PostRepositoryImpl
import com.pr7.jc_retrofit_mvvm_clean_architecture.domain.repository.PostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun providePostRepository(impl: PostRepositoryImpl):PostRepository
}