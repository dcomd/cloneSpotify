package com.br.spotify

import android.content.Context
import android.content.res.AssetManager
import com.br.spotify.domain.model.PlayList
import com.br.spotify.domain.model.SpotifyArtist
import com.br.spotify.domain.model.User
import com.google.gson.Gson


object Components {

    fun getInfo(context: Context): List<SpotifyArtist.Artist>? {
        val gson = Gson()
        val file = context.assets.readAssetsFile("art.json")
        val spotifyArtist: SpotifyArtist = gson.fromJson(file, SpotifyArtist::class.java)

        return spotifyArtist.items
    }

    fun getPlay(context: Context): List<PlayList.Item> {
        val gson = Gson()
        val file = context.assets.readAssetsFile("playlist.json")
        val spotifyArtist: PlayList.PlaylistResponse = gson.fromJson(file, PlayList.PlaylistResponse::class.java)

        return spotifyArtist.items
    }

    fun getProfile(context: Context): User.UserData {
        val gson = Gson()
        val file = context.assets.readAssetsFile("user.json")

        return gson.fromJson(file, User.UserData::class.java)
    }


    private fun AssetManager.readAssetsFile(fileName : String): String = open(fileName).bufferedReader().use{it.readText()}

}