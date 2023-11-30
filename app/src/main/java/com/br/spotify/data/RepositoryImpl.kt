package com.br.spotify.data

import kaaes.spotify.webapi.android.SpotifyApi
import kaaes.spotify.webapi.android.models.Album
import kaaes.spotify.webapi.android.models.Artist
import kaaes.spotify.webapi.android.models.Pager
import kaaes.spotify.webapi.android.models.Playlist
import kaaes.spotify.webapi.android.models.PlaylistSimple
import kaaes.spotify.webapi.android.models.UserPrivate
import javax.inject.Inject

const val TOKEN = "BQDCHLA9nZjAZ2-mDK_KdltQXZw5DxgswC4PmO7CUnJI30VYTuDyxql9D3KDvlAfwzMFb4WcB_bzk8vlcxuc0PBh5Y9aKN0rFZ8dh7idhGZNAcTLV_Y"


class RepositoryImpl @Inject constructor(): Repository {

    private val spotifyApi = SpotifyApi().setAccessToken(TOKEN)

    override suspend fun getArt(): Pager<Artist> {
        val spotifyService = spotifyApi.service
        if (!spotifyService.topArtists.items.isNullOrEmpty()){
            return spotifyService.topArtists
        }
        return spotifyService.topArtists
    }

    override suspend fun getProfile(): UserPrivate {
        val spotifyService = spotifyApi.service
        return spotifyService.me
    }

    override suspend fun getPlayList(): Pager<PlaylistSimple> {
        val spotifyService = spotifyApi.service
        return spotifyService.myPlaylists
    }
}