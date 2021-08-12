import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    Example3.solve().join()
}

object Example3 {

    /**
     * Return a Job that is referring all the launched functions.
     * The Job should ignore the failure of a child
     *
     * Expected output:
     *
     * Sum: 6
     * Division: 2
     */
    fun solve(): Job {
        val scope = GlobalScope
        sum(scope)
        multiplication(scope)
        division(scope)
        TODO("Return a custom job here")
    }

    /**
     * Do not change this function
     */
    private fun sum(scope: CoroutineScope) {
        scope.launch {
            delay(1000)

            println("Sum: ${4 + 2}")
        }
    }

    /**
     * Do not change this function
     */
    private fun multiplication(scope: CoroutineScope) {
        scope.launch {
            throw Throwable("Exception")
            delay(2000)
            println("Multiplication: ${4 * 2}")
        }
    }

    /**
     * Do not change this function
     */
    private fun division(scope: CoroutineScope) {
        scope.launch {
            delay(3000)

            println("Division: ${4 / 2}")
        }
    }

}