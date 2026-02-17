package dev.marcosalis.clean.ktx.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.MainCoroutineDispatcher

/**
 * Abstraction over coroutine [kotlinx.coroutines.Dispatchers] to simplify dependency injection
 * and testing.
 */
interface DispatcherProvider {

    val main: MainCoroutineDispatcher

    val default: CoroutineDispatcher

    val io: CoroutineDispatcher

    val unconfined: CoroutineDispatcher

}
