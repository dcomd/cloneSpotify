package com.br.spotify.data

import kaaes.spotify.webapi.android.models.Album
import kaaes.spotify.webapi.android.models.Pager
import  kaaes.spotify.webapi.android.models.Artist
import kaaes.spotify.webapi.android.models.Playlist
import kaaes.spotify.webapi.android.models.PlaylistSimple
import kaaes.spotify.webapi.android.models.UserPrivate


interface Repository {

    suspend fun getArt(): Pager<Artist>

    suspend fun getProfile(): UserPrivate

    suspend fun getPlayList(): Pager<PlaylistSimple>
}