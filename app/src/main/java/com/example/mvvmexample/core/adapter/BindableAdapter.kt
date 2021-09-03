package com.example.mvvmexample.core.adapter

interface BindableAdapter<T> {
    fun setItems(items: List<T>)
}