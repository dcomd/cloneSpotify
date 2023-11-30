package com.br.spotify.domain.model

class User {

    data class UserData(
        val country: String,
        val display_name: String,
        val email: String,
        val explicit_content: ExplicitContent,
        val external_urls: ExternalUrls,
        val followers: Followers,
        val href: String,
        val id: String,
        val images: List<Image>,
        val product: String,
        val type: String,
        val uri: String
    )

    data class ExplicitContent(
        val filter_enabled: Boolean,
        val filter_locked: Boolean
    )

    data class ExternalUrls(
        val spotify: String
    )

    data class Followers(
        val href: String,
        val total: Int
    )

    data class Image(
        val url: String,
        val height: Int,
        val width: Int
    )

}