package com.csergio.composepractice

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

class MainViewModel: ViewModel() {
}

sealed interface SplashState {
    object Showing : SplashState
    object Finished : SplashState
}