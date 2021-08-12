package suspend

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        Example2.solve(
            { fakeNetworkCall("Call 1") },
            { fakeNetworkCall("Call 2") },
            { fakeNetworkCall("Call 3") },
        )
    }.join()
}

object Example2 {

    /**
     * Implement a function that execute all the provided network calls at the same times like a zip operator
     *
     * Expected output:
     *
     * Starting Network Call Call 1
     * Starting Network Call Call 2
     * Starting Network Call Call 3
     *
     * Network Call Call 1 executed
     * Network Call Call 2 executed
     * Network Call Call 3 executed
     *
     * Tips: Use coroutineScope { } and async
     */
    suspend fun solve(vararg calls: suspend () -> Unit) {

    }
}

/**
 * Do not change this function
 */
private suspend fun fakeNetworkCall(fakeName: String) {
    println("Starting Network Call $fakeName")
    delay(2000)
    println("Network Call $fakeName executed")
}