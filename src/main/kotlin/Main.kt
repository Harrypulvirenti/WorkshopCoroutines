import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch {
        val user = async { fetchUser() }

        println("Inside Launch | Thread ${Thread.currentThread()}")

        println("User: ${user.await().name}")
    }.join()
}

suspend fun fetchUser(): User {
    println("Fetch User | Thread ${Thread.currentThread()}")

    delay(2000)

    println("Delay Finished | Thread ${Thread.currentThread()}")

    return User("Enrico")
}

data class User(val name: String)