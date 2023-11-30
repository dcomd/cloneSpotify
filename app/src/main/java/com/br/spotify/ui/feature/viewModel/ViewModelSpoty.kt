package com.br.spotify.ui.feature.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.spotify.domain.ResultState
import com.br.spotify.domain.UseCaseGetArt
import com.br.spotify.domain.UseCaseGetPlayList
import com.br.spotify.domain.UseCaseGetProfile
import com.br.spotify.ui.feature.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModelSpoty @Inject constructor(private val useCaseGetArt: UseCaseGetArt, private val useCaseGetPlayList: UseCaseGetPlayList , private val useCaseGetProfile: UseCaseGetProfile) : ViewModel() {
    var initState: MutableLiveData<UiState> = MutableLiveData()

    fun fetchData() {
        viewModelScope.launch {
            useCaseGetArt.invoke()
                .collect {
                    if (it is ResultState.Success) {
                        initState.postValue(it.data?.let { it1 -> UiState.Success(it1) })
                    }
                }
        }
    }

    fun fetchPlayList() {
        viewModelScope.launch {
            useCaseGetPlayList.invoke()
                .collect {
                    if (it is ResultState.Success) {
                        initState.postValue(it.data?.let { it1 -> UiState.SuccessPlayList(it1) })
                    }
                }
        }
    }

    fun fetchProfile() {
        viewModelScope.launch {
            useCaseGetProfile.invoke()
                .collect {
                    if (it is ResultState.Success) {
                        initState.postValue(it.data?.let { it1 -> UiState.SuccessProfile(it1) })
                    }
                }
        }
    }
}