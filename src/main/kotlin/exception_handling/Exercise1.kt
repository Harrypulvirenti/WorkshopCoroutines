package exception_handling

import kotlinx.coroutines.*

fun main() = runBlocking {
    Exercise1.run().join()
}

object Exercise1 {
    /**
     * Prevent the below coroutine from throwing exception then crashing,
     * and print a log with the exception.
     * Tip: use other method than try/catch
     */
    fun run(): Job{
        val topLevelScope = CoroutineScope(Job())
        return topLevelScope.launch() {
            try {
                launch {
                    throw ExampleLaunchCustomException()
                }
            } catch (exception: Exception) {
                println("Attempt to handle $exception")
            }
        }
    }
}

class ExampleLaunchCustomException : Throwable()
