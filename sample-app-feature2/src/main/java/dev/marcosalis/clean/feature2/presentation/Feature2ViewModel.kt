package dev.marcosalis.clean.feature2.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.marcosalis.clean.feature2.entity.Feature2Action
import dev.marcosalis.feature2.business.Feature2UseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class Feature2ViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    useCase: Feature2UseCase
) : ViewModel() {

    private val route = savedStateHandle.toRoute<Feature2Route>()

    private val id = route.id

    // using new Kotlin 2.3.0 "explicit backing fields"
    val uiState: StateFlow<Feature2UiState>
        field = MutableStateFlow(Feature2UiState(id))

    init {
        viewModelScope.launch {
            useCase.doStuff(Feature2Action(parameter1 = route.parameter1))
        }
    }
}
