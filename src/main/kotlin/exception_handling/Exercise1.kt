package exception_handling

import kotlinx.coroutines.*

fun main() = runBlocking {
    Exercise1.run().join()
}

object Exercise1 {
    /**
     * Prevent the below coroutine from throwing exception then crashing,
     * and print a log with the exception.
     */
    fun run(): Job {
        val ceh = CoroutineExceptionHandler { _, e ->
            when (e) {
                is ExampleLaunchCustomException -> println("Handled custom $e")
                else -> println("Handled $e")
            }

        }
        val topLevelScope = CoroutineScope(Job())
        return topLevelScope.launch(ceh) {
            launch {
                throw ExampleLaunchCustomException()
            }
        }
    }
}

class ExampleLaunchCustomException : Throwable()
