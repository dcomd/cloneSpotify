package com.br.spotify.di

import com.br.spotify.data.Repository
import com.br.spotify.data.RepositoryImpl
import com.br.spotify.domain.UseCaseGetArt
import com.br.spotify.domain.UseCaseGetPlayList
import com.br.spotify.domain.UseCaseGetProfile
import dagger.Module
import dagger.hilt.InstallIn
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {

    @Provides
    @Singleton
    fun provideUseCase(repositoryImp: RepositoryImpl): UseCaseGetArt {
        return UseCaseGetArt(repositoryImp)
    }

    @Provides
    @Singleton
    fun provideUseCaseGetMe(repositoryImp: RepositoryImpl): UseCaseGetProfile {
        return UseCaseGetProfile(repositoryImp)
    }

    @Provides
    @Singleton
    fun provideUseCasePlayList(repositoryImp: RepositoryImpl): UseCaseGetPlayList {
        return UseCaseGetPlayList(repositoryImp)
    }


    @Provides
    @Singleton
    fun provideApiRepository(): Repository {
        return RepositoryImpl()
    }
}