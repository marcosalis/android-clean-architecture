@file:Suppress("UNUSED_PARAMETER")

package com.teamwork.android.samples.clean.data.feature2

import com.squareup.moshi.Moshi
import com.teamwork.android.samples.clean.data.access.DataRequest
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import com.teamwork.android.samples.clean.data.access.feature2.Entity2Repo
import com.teamwork.android.samples.clean.entity.feature2.Entity2
import okhttp3.OkHttpClient
import timber.log.Timber
import javax.annotation.concurrent.ThreadSafe
import javax.inject.Inject

@ThreadSafe
@Suppress("unused")
class Entity2RepoImpl
@Inject constructor(
    val entity1Repo: Entity1Repo,
    val okHttpClient: OkHttpClient,
    val moshi: Moshi
) : Entity2Repo {

    init {
        Timber.i("Initializing '${Entity2RepoImpl::class.simpleName}' (singleton)")
    }

    override fun getEntity2(id: Long): DataRequest<Entity2> {
        throw UnsupportedOperationException()
    }

}
