package com.teamwork.android.samples.clean.feature1.detail

import androidx.lifecycle.ViewModel
import com.teamwork.android.samples.clean.business.Interactor
import com.teamwork.android.samples.clean.business.feature1.detail.Feature1DetailsInteractor
import com.teamwork.android.samples.clean.entity.feature1.Entity1
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Feature1DetailsViewModel @Inject constructor(
    private val interactor: Feature1DetailsInteractor
) : ViewModel(), Interactor.Callback<Entity1> {

    init {
        interactor.registerCallback(this)
    }

    override fun onCleared() {
        interactor.unregisterCallback()
    }

    override fun onDataLoaded(data: Entity1) {
        TODO("Not yet implemented")
    }

    override fun onDataLoadError(exception: Exception) {
        TODO("Not yet implemented")
    }

}
