@file:Suppress("unused")

package com.teamwork.android.samples.clean.business.feature1.detail

import android.content.Context
import com.teamwork.android.samples.clean.business.BaseInteractor
import com.teamwork.android.samples.clean.business.Interactor
import com.teamwork.android.samples.clean.business.internal.InternalInteractor
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import com.teamwork.android.samples.clean.data.access.feature2.Entity2Repo
import com.teamwork.android.samples.clean.entity.feature1.Entity1
import dagger.hilt.android.qualifiers.ApplicationContext
import timber.log.Timber
import javax.inject.Inject

internal class Feature1DetailsInteractorImpl @Inject constructor(
    @ApplicationContext private val context: Context,
    private val internalInteractor: InternalInteractor,
    private val entity1Repo: Entity1Repo,
    private val entity2Repo: Entity2Repo
) : BaseInteractor<Entity1, Interactor.Callback<Entity1>>(), Feature1DetailsInteractor {

    init {
        Timber.i("Initializing '${Feature1DetailsInteractorImpl::class.simpleName}'")
    }

}
