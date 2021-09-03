package com.example.mvvmexample.core.network

interface NetworkStateProvider {
    fun isNetworkAvailable(): Boolean
}