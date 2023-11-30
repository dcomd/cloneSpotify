package com.br.spotify.domain.model

class SpotifyArtist {
    class ExternalUrls {
        var spotify: String? = null
    }

    class Followers {
        var href: String? = null
        var total = 0
    }

    class Image {
        var url: String? = null
        var height = 0
        var width = 0
    }

    class Artist {
        var external_urls: ExternalUrls? = null
        var followers: Followers? = null
        var genres: List<String>? = null
        var href: String? = null
        var id: String? = null
        var images: List<Image>? = null
        var name: String? = null
        var popularity = 0
        var type: String? = null
        var uri: String? = null
    }

    var items: List<Artist>? = null
}