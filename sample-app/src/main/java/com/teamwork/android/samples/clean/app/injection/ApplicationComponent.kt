package com.teamwork.android.samples.clean.app.injection

import android.content.Context
import com.teamwork.android.samples.clean.app.SampleActivity
import com.teamwork.android.samples.clean.app.feature2.detail.Feature2DetailsActivity
import com.teamwork.android.samples.clean.business.injection.BusinessComponent
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Singleton
@Component(
    dependencies = [
        BusinessComponent::class
    ]
)
interface ApplicationComponent {

    @EntryPoint
    @InstallIn(SingletonComponent::class)
    interface AggregatorEntryPoint : ApplicationComponent

    companion object {
        /**
         * The singleton instance for [ApplicationComponent].
         * This is initialised by the `presentation` layer itself and primarily used to inject dependencies.
         * The instance can be replaced with a mock for testing when necessary.
         */
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: ApplicationComponent
    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        @ApplicationContext
        fun appContext(applicationContext: Context): Builder

        fun businessComponent(businessComponent: BusinessComponent): Builder

        fun build(): ApplicationComponent

    }

    fun inject(activity: SampleActivity)

    fun inject(activity: Feature2DetailsActivity)

}
