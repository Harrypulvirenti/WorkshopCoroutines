package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    val givenStream = flowOf(Unit, Unit, Unit)
    Example3.solve(false, givenStream)
        .collect { value ->
            println(value)
        }
}

object Example3 {

    /**
     * Implement toggle mechanism.
     * Initially return [initialValue],
     * then each time [source] emits value,
     * negate value previously emitted by your Flow.
     */
    fun solve(initialValue: Boolean, source: Flow<Unit>): Flow<Boolean> {
        TODO()
    }
}

