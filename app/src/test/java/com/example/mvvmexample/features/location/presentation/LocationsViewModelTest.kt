package com.example.mvvmexample.features.location.presentation

import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import com.example.mvvmexample.core.base.UiState
import com.example.mvvmexample.core.exception.ErrorMapper
import com.example.mvvmexample.features.location.all.presentation.LocationsViewModel
import com.example.mvvmexample.features.location.all.presentation.model.LocationDisplayable
import com.example.mvvmexample.features.location.domain.GetLocationsUseCase
import com.example.mvvmexample.features.location.domain.model.Location
import com.example.mvvmexample.features.location.navigation.LocationNavigator
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

internal class LocationsViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN episode is clicked THAN open episode details screen`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = LocationsViewModel(useCase, locationNavigator, errorMapper)
        val location = LocationDisplayable.mock()

        //when
        viewModel.onLocationClick(location)

        //than
        verify { locationNavigator.openLocationDetailsScreen(location) }
    }

    @Test
    fun `WHEN locations live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = LocationsViewModel(useCase, locationNavigator, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Pending
    }

    @Test
    fun `WHEN locations live data is observed THEN invoke use case to get locations`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = LocationsViewModel(useCase, locationNavigator, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        verify { useCase(viewModel.viewModelScope, Unit, any(), any()) }
    }

    @Test
    fun `GIVEN use case result is success WHEN locations live data is observed THEN set idle state AND set result in live data`() {
        val locations = listOf(Location.mock(), Location.mock(), Location.mock())
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.success(locations))
            }
        }
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = LocationsViewModel(useCase, locationNavigator, errorMapper)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        viewModel.locations.getOrAwaitValue().forEachIndexed { index, locationDisplayable ->
            val location = locations[index]
            locationDisplayable.name `should be` location.name
            locationDisplayable.type `should be` location.type
            locationDisplayable.dimension `should be` location.dimension
        }
    }

    @Test
    fun `GIVEN use case result is failure WHEN episode live data is observed THEN set idle state AND set error message in live data`() {
        val throwable = Throwable("Ops... something went wrong")
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val locationNavigator = mockk<LocationNavigator>(relaxed = true)
        val observer = mockk<Observer<String>>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val viewModel = LocationsViewModel(useCase, locationNavigator, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UiState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}