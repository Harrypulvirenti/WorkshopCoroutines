import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // Create here your Scope
    Example1.solve(GlobalScope).join()
}

object Example1 {

    /**
     * Pass to this function a custom scope instead of using the GlobalScope
     */
    fun solve(scope: CoroutineScope): Job =
        scope.launch {
            val coroutineName = requireNotNull(coroutineContext[CoroutineName]) {
                "You must use a coroutine scope with a coroutine name not null"
            }
            println("Coroutine Name $coroutineName")
            delay(2000)
            println("Hello Coroutines!")
        }
}