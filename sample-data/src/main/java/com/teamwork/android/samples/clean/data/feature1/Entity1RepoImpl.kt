@file:Suppress("UNUSED_PARAMETER")

package com.teamwork.android.samples.clean.data.feature1

import android.content.Context
import com.squareup.moshi.Moshi
import com.teamwork.android.samples.clean.data.access.DataRequest
import com.teamwork.android.samples.clean.data.access.feature1.Entity1Repo
import com.teamwork.android.samples.clean.entity.feature1.Entity1
import com.teamwork.android.samples.clean.entity.feature1.Entity1List
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.OkHttpClient
import javax.annotation.concurrent.ThreadSafe
import javax.inject.Inject

@ThreadSafe
@Suppress("unused")
class Entity1RepoImpl
@Inject constructor(
    @ApplicationContext val appContext: Context,
    val okHttpClient: OkHttpClient,
    val moshi: Moshi
) : Entity1Repo {

    override fun initialize() {} // does initialization stuff!

    override fun getEntity1(id: Long): DataRequest<Entity1> {
        throw UnsupportedOperationException()
    }

    override fun getEntity1List(): DataRequest<Entity1List> {
        throw UnsupportedOperationException()
    }

}