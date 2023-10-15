package com.csergio.composepractice.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
}

sealed interface SplashState {
    object Showing : SplashState
    object Finished : SplashState
}