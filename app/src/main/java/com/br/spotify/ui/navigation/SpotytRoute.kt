package com.br.spotify.ui.navigation

internal sealed class SpotytRoute(val route: String) {

    object SpotytInitial : SpotytRoute(route = "initial_screen")

    object SpotytHome: SpotytRoute(route = "home_screen")

    object SpotytPLasyList : SpotytRoute(route = "playlist_screen")

    object SpotytProfile : SpotytRoute(route = "profile_screen")

    object SpotytAlbum : SpotytRoute(route = "album_screen")
}