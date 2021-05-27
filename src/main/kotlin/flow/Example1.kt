package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    Example1.solve().collect { value -> println(value) }
}

object Example1 {
    /**
     * Create flow that will emit next Int values from 0 to 10 with 10ms delay after each emission
     */
    fun solve(): Flow<Int> {
        TODO()
    }
}