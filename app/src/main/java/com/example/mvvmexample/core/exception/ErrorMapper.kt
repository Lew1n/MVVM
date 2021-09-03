package com.example.mvvmexample.core.exception

interface ErrorMapper {
    fun map(throwable: Throwable): String
}