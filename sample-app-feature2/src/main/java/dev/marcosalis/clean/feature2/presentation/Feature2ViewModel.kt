package dev.marcosalis.clean.feature2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.marcosalis.clean.feature2.entity.Feature2Action
import dev.marcosalis.feature2.business.usecase.Feature2UseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// note: Navigation 3 doesn't provide a direct `toRoute` with a `SavedStateHandle` to pass route
@HiltViewModel(assistedFactory = Feature2ViewModel.Factory::class)
internal class Feature2ViewModel @AssistedInject constructor(
    @Assisted val route: Feature2Route,
    useCase: Feature2UseCase
) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(route: Feature2Route): Feature2ViewModel
    }

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
