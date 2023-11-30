package com.br.spotify.domain

import com.br.spotify.data.RepositoryImpl
import kaaes.spotify.webapi.android.models.Pager
import kaaes.spotify.webapi.android.models.PlaylistSimple
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class UseCaseGetPlayList(private val repositoryImpl : RepositoryImpl) {
    fun invoke(): Flow<ResultState<Pager<PlaylistSimple>?, ErrorResult>> =
        flow<ResultState<Pager<PlaylistSimple>?,ErrorResult>>{
            val result = repositoryImpl.getPlayList()
            emit(ResultState.Success(result))
        }.catch {
            emit(ResultState.Error(ErrorResult(it.message.toString())))
        }

}



