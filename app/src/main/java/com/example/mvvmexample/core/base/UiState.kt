package com.example.mvvmexample.core.base

sealed class UiState {
    object Idle : UiState()
    object Pending : UiState()
}