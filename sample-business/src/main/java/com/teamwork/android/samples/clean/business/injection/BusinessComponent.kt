package com.teamwork.android.samples.clean.business.injection

import com.teamwork.android.samples.clean.data.access.DataAccessComponent
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface BusinessComponent {

    companion object {
        const val GLOBAL_COMPUTATION_EXECUTOR = DataAccessComponent.GLOBAL_COMPUTATION_EXECUTOR
        const val GLOBAL_IO_EXECUTOR = DataAccessComponent.GLOBAL_IO_EXECUTOR
    }

    /*
     * Provision methods for public interactors that need to be exposed to the presentation layer.
     * Any other interactor implementation which is not declared here will only be accessible from within this layer.
     */

//    fun feature1DetailsInteractor(): Feature1DetailsInteractor
//
//    fun feature1ListInteractor(): Feature1ListInteractor
//
//    fun feature2DetailsInteractor(): Feature2DetailsInteractor


    //region exposed cross-layer dependencies

//    @Named(GLOBAL_COMPUTATION_EXECUTOR)
//    fun computationExecutor(): ExecutorService

    // internal fun inject(businessLayerInitializer: BusinessLayerInitializer)

    //endregion

}

//@Singleton
//@Component(
//    dependencies = [
//        DataAccessComponent::class
//    ]
//)
internal interface InternalBusinessComponent : BusinessComponent {

    companion object {
        /**
         * The singleton instance for [InternalBusinessComponent].
         * This is initialised by the `business` layer itself and primarily used to inject internal dependencies.
         * The instance can be replaced with a mock for testing when necessary.
         */
        @Volatile
        @JvmStatic
        lateinit var INSTANCE: BusinessComponent
    }

//    @Component.Factory
//    interface Factory {
//        fun create(
//            @ApplicationContext @BindsInstance applicationContext: Context,
//            dataAccessComponent: DataAccessComponent
//        ): InternalBusinessComponent
//    }

    //region `data` layer injectable classes

    fun inject(businessLayerInitializer: BusinessLayerInitializer)

    //endregion

}
