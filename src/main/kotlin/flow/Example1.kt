package flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    Example1.solve().collect { value -> println(value) }
}

object Example1 {
    /**
     * Create flow that will emit Int values from 0 to 10 with [DELAY_STEP_AMOUNT] delay BEFORE each emission.
     */
    fun solve(): Flow<Int> {
        return (0..10).asFlow().onEach {
            delay(DELAY_AMOUNT)
        }
    }
}

const val DELAY_STEP_AMOUNT = 100L