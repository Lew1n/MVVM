package com.example.mvvmexample.core.exception

interface ErrorWrapper {
    fun wrap(throwable: Throwable): Throwable
}