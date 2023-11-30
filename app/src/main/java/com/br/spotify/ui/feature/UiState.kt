package com.br.spotify.ui.feature

import kaaes.spotify.webapi.android.models.Artist
import kaaes.spotify.webapi.android.models.Pager
import kaaes.spotify.webapi.android.models.PlaylistSimple
import kaaes.spotify.webapi.android.models.UserPrivate


sealed interface UiState {

    data class Success(val data : Pager<Artist>) : UiState

    data class SuccessProfile(val data : UserPrivate) : UiState

    data class SuccessPlayList(val data : Pager<PlaylistSimple>) : UiState
}