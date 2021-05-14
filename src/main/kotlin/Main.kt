import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking{
    GlobalScope.launch {
        println("Hello Coroutines!")
    }.join()
}