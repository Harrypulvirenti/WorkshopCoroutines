import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {

        concat(
            { fakeNetworkCall("Call 1") },
            { fakeNetworkCall("Call 2") },
            { fakeNetworkCall("Call 3") },
        )

        zip(
            { fakeNetworkCall("Call 1") },
            { fakeNetworkCall("Call 2") },
            { fakeNetworkCall("Call 3") },
        )
    }.join()
}

// Implement a function that execute all the provided calls
// one after other
private suspend fun concat(vararg calls: suspend () -> Unit) {
    // Your implementation here
}

// Implement a function that execute all the provided calls
// at the same times
private suspend fun zip(vararg calls: suspend () -> Unit) {
    // Your implementation here
}

private suspend fun fakeNetworkCall(fakeName: String) {
    println("Starting Network Call $fakeName")
    delay(2000)
    println("Network Call $fakeName executed")
}
