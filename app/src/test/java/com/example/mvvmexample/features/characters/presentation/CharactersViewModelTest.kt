package com.example.mvvmexample.features.characters.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.core.base.UiState
import com.example.mvvmexample.core.exception.ErrorMapper
import com.example.mvvmexample.features.characters.all.presentation.CharactersViewModel
import com.example.mvvmexample.features.characters.all.presentation.model.CharacterDisplayable
import com.example.mvvmexample.features.characters.domain.GetCharacterUseCase
import com.example.mvvmexample.features.characters.domain.model.Character
import com.example.mvvmexample.features.characters.navigation.CharacterNavigator
import com.example.mvvmexample.mock.mock
import com.example.mvvmexample.utils.ViewModelTest
import com.example.mvvmexample.utils.getOrAwaitValue
import com.example.mvvmexample.utils.observeForTesting
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.`should be`
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class CharactersViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN character is clicked THAN open character details screen`() {
        //given
        val useCase = mockk<GetCharacterUseCase>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CharactersViewModel(useCase, characterNavigator, errorMapper)
        val character = CharacterDisplayable.mock()

        //when
        viewModel.onCharacterClick(character)

        //than
        verify { characterNavigator.openCharacterDetailsScreen(character) }
    }

    @Test
    fun `WHEN characters live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetCharacterUseCase>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CharactersViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN characters live data is observed THEN invoke use case to get characters`() {
        //given
        val useCase = mockk<GetCharacterUseCase>(relaxed = true)
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CharactersViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        verify { useCase(viewModel.viewModelScope, Unit, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN characters live data is observed THEN set idle state AND set result in live data`() {
        val characters = listOf(Character.mock(), Character.mock(), Character.mock())
        val useCase = mockk<GetCharacterUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.success(characters))
            }
        }
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CharactersViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.characters.getOrAwaitValue().forEachIndexed { index, characterDisplayable ->
            val character = characters[index]
            characterDisplayable.name `should be` character.name
            characterDisplayable.status `should be` character.status
            characterDisplayable.species `should be` character.species
            characterDisplayable.type `should be` character.type
            characterDisplayable.gender `should be` character.gender
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN character live data is observed THEN set idle state AND set error message in live data`() {
        val throwable = Throwable("Ops... something went wrong")
        val useCase = mockk<GetCharacterUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val characterNavigator = mockk<CharacterNavigator>(relaxed = true)
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val viewModel = CharactersViewModel(useCase, characterNavigator, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}