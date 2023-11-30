package com.br.spotify.domain


sealed interface ResultState<Data,Error>{
    data class Success<Data,Error>(val data : Data): ResultState<Data,Error>

    data class Error<Data,Error>(val error: Error): ResultState<Data,Error>
}

data class ErrorResult(
    val message:String
)