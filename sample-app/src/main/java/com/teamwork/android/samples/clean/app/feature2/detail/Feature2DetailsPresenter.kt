package com.teamwork.android.samples.clean.app.feature2.detail

import android.content.Context
import com.teamwork.android.samples.clean.business.Interactor
import com.teamwork.android.samples.clean.business.feature1.list.Feature1ListInteractor
import com.teamwork.android.samples.clean.business.feature2.detail.Feature2DetailsInteractor
import com.teamwork.android.samples.clean.business.injection.BusinessComponent
import com.teamwork.android.samples.clean.core.BasePresenter
import com.teamwork.android.samples.clean.entity.feature2.Entity2
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import java.util.concurrent.ExecutorService
import javax.inject.Inject
import javax.inject.Named

@Suppress("unused")
class Feature2DetailsPresenter @Inject constructor(
    private val interactor: Feature2DetailsInteractor,
    private val interactorList: Feature1ListInteractor,

    @ApplicationContext private val appContext: Context,

    @Named(BusinessComponent.GLOBAL_IO_EXECUTOR)
    private val ioExecutor: ExecutorService,

    @Named(BusinessComponent.GLOBAL_COMPUTATION_EXECUTOR)
    private val computationExecutor: ExecutorService

    // private val internalInteractor: InternalInteractor // this (and rightly so) doesn't even compile!
) : BasePresenter<Feature2DetailsView>(), Interactor.Callback<Entity2> {

    init {
        Timber.i("Initializing '${Feature2DetailsPresenter::class.simpleName}'")
    }

    override fun onViewCreated(view: Feature2DetailsView) {
        super.onViewCreated(view)
        interactor.registerCallback(this)
    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
        interactor.unregisterCallback()
    }

    override fun onDataLoaded(data: Entity2) {
        computationExecutor.submit { /* do stuff here */ }
    }

    override fun onDataLoadError(exception: Exception) {
    }

}
