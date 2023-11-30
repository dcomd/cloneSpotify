package com.br.spotify.domain

import com.br.spotify.data.RepositoryImpl
import kaaes.spotify.webapi.android.models.Artist
import kaaes.spotify.webapi.android.models.Pager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class UseCaseGetArt(private val repositoryImpl : RepositoryImpl) {
    fun invoke(): Flow<ResultState<Pager<Artist>?, ErrorResult>> =
        flow<ResultState<Pager<Artist>?,ErrorResult>>{
            val result = repositoryImpl.getArt()
            emit(ResultState.Success(result))
        }.catch {
            emit(ResultState.Error(ErrorResult(it.message.toString())))
        }
}



