package dev.marcosalis.clean.presentation.feature1

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.marcosalis.clean.business.entity.feature1.Feature1Action
import dev.marcosalis.clean.business.feature1.Feature1UseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Feature1ViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCase: Feature1UseCase
) : ViewModel() {

    private val route = savedStateHandle.toRoute<Feature1Route>()

    private val id = route.id

    val uiState: StateFlow<Feature1UiState> =
        useCase.data
            .map {
                Feature1UiState(
                    id = it.id,
                    showText = it.isParameterValid(),
                    text = it.parameter1
                )
            }
            // we use StateFlow in here so the initial state doesn't need to be specified in a composable
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = Feature1UiState(id = id, showText = false)
            )

    @Suppress("unused")
    fun onUserAction(userInput: String) {
        viewModelScope.launch {
            useCase.performAction(
                payload = Feature1Action(
                    parameter1 = true,
                    parameter2 = userInput
                )
            )
        }
    }
}
