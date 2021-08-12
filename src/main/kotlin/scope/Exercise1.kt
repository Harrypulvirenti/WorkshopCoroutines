import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    Example1.solve().join()
}

object Example1 {

    /**
     * Instantiate a custom scope with a name instead of using the GlobalScope
     *
     * Expected output:
     * Coroutine Name $coroutineName
     *
     * 2 seconds Delay
     *
     * Hello Coroutines!
     */
    fun solve(): Job {
        val scope = CoroutineScope(CoroutineName("Custom Name"))
        return run(scope)
    }

    /**
     * Do not change this function
     */
    private fun run(scope: CoroutineScope): Job =
        scope.launch {
            val coroutineName = requireNotNull(coroutineContext[CoroutineName]) {
                "You must use a coroutine scope with a coroutine name not null"
            }
            println("Coroutine Name $coroutineName")
            delay(2000)
            println("Hello Coroutines!")
        }
}