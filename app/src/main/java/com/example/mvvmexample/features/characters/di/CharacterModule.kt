package com.example.mvvmexample.features.characters.di

import com.example.mvvmexample.features.characters.all.presentation.CharacterAdapter
import com.example.mvvmexample.features.characters.all.presentation.CharactersFragment
import com.example.mvvmexample.features.characters.all.presentation.CharactersViewModel
import com.example.mvvmexample.features.characters.data.repository.CharacterRepositoryImpl
import com.example.mvvmexample.features.characters.details.CharacterDetailsFragment
import com.example.mvvmexample.features.characters.details.CharacterViewModel
import com.example.mvvmexample.features.characters.domain.CharacterRepository
import com.example.mvvmexample.features.characters.domain.GetCharacterUseCase
import com.example.mvvmexample.features.characters.navigation.CharacterNavigator
import com.example.mvvmexample.features.characters.navigation.CharacterNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetCharacterUseCase(get()) }

    //presentation
    viewModel { CharactersViewModel(get(), get(), get()) }
    viewModel { CharacterViewModel() }
    factory { CharactersFragment() }
    factory { CharacterDetailsFragment() }
    factory { CharacterAdapter() }

    //navigation
    factory<CharacterNavigator> { CharacterNavigatorImpl(get()) }
}
