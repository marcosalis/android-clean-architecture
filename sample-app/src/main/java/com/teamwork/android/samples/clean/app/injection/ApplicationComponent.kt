package com.teamwork.android.samples.clean.app.injection

import android.content.Context
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

}
