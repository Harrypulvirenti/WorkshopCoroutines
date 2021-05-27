package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    Example5.solve()
        .collect { value ->
            println(value)
        }
}

object Example5 {

    /**
     * Emit num numbers from 1 to 5. But throw a [RuntimeException] if n == 3
     * then catch the exception and print the msg.
     */
    fun solve(): Flow<Int> {
        TODO()
    }
}