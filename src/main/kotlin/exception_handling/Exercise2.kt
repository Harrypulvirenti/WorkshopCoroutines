package exception_handling

import kotlinx.coroutines.*

fun main() = runBlocking {
    Exercise2.run()
}

object Exercise2 {
    /**
     * Prevent the below coroutine from throwing exception then crashing,
     * and print a log with the exception.
     */
    suspend fun run() {
        val topLevelScope = CoroutineScope(SupervisorJob())
        val deferred = topLevelScope.async<Unit> {
            throw ExampleAwaitCustomException()
        }

        deferred.await()
    }
}

class ExampleAwaitCustomException : Throwable()
