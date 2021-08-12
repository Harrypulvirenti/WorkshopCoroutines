package suspend

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        Example1.solve(
            { fakeNetworkCall("Call 1") },
            { fakeNetworkCall("Call 2") },
            { fakeNetworkCall("Call 3") },
        )
    }.join()
}

object Example1 {

    /**
     * Implement a function that execute all the provided network calls in row like a concat operator
     *
     * Expected output:
     *
     * Starting Network Call Call 1
     * Network Call Call 1 executed
     *
     * Starting Network Call Call 2
     * Network Call Call 2 executed
     *
     * Starting Network Call Call 3
     * Network Call Call 3 executed
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