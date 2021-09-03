package com.example.mvvmexample.core.di

import android.content.Context
import android.net.ConnectivityManager
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmexample.R
import com.example.mvvmexample.core.exception.ErrorMapper
import com.example.mvvmexample.core.exception.ErrorMapperImpl
import com.example.mvvmexample.core.exception.ErrorWrapper
import com.example.mvvmexample.core.exception.ErrorWrapperImpl
import com.example.mvvmexample.core.navigation.FragmentNavigator
import com.example.mvvmexample.core.navigation.FragmentNavigatorImpl
import com.example.mvvmexample.core.network.NetworkStateProvider
import com.example.mvvmexample.core.network.NetworkStateProviderImpl
import com.example.mvvmexample.core.provider.ActivityProvider
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

const val NUMBER_OF_COLUMNS = 2

val appModule = module {

    factory {
        LinearLayoutManager(androidContext())
    }

    factory {
        GridLayoutManager(androidContext(), NUMBER_OF_COLUMNS)
    }

    factory {
        DividerItemDecoration(androidContext(), LinearLayoutManager.HORIZONTAL)
    }

    factory {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    factory<NetworkStateProvider> {
        NetworkStateProviderImpl(get())
    }

    factory<ErrorWrapper> {
        ErrorWrapperImpl()
    }

    factory<ErrorMapper> {
        ErrorMapperImpl(androidContext())
    }

    single(createdAtStart = true) { ActivityProvider(androidApplication()) }

    factory<FragmentNavigator> {
        FragmentNavigatorImpl(
            activityProvider = get(),
            navHostFragmentRes = R.id.nav_host_fragment,
            homeDestinationRes = R.id.characters_screen,
            defaultNavOptions = get()
        )
    }

    factory {
        navOptions {
            anim { enter = R.anim.fragment_fade_enter }
            anim { exit = R.anim.fragment_fade_exit }
            anim { popEnter = R.anim.fragment_close_enter }
            anim { popExit = R.anim.fragment_close_exit }
        }
    }
}