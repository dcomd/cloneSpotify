package com.br.spotify.domain

import com.br.spotify.data.RepositoryImpl
import kaaes.spotify.webapi.android.models.Pager
import kaaes.spotify.webapi.android.models.PlaylistSimple
import kaaes.spotify.webapi.android.models.UserPrivate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class UseCaseGetProfile(private val repositoryImpl : RepositoryImpl) {
    fun invoke(): Flow<ResultState<UserPrivate?, ErrorResult>> =
        flow<ResultState< UserPrivate?,ErrorResult>>{
            val result = repositoryImpl.getProfile()
            emit(ResultState.Success(result))
        }.catch {
            emit(ResultState.Error(ErrorResult(it.message.toString())))
        }

}



