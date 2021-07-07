package flow

import kotlinx.coroutines.flow.*
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
     * then catch the exception, print the msg and stop execution.
     */
    fun solve(): Flow<Int> {
        return (1..5).asFlow().onEach { number ->
            if(number == 3)
                throw RuntimeException("Error Message")
        }.catch { exception ->
            print(exception.message)
        }
    }
}