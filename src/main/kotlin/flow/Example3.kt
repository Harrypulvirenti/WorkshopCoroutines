package flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.runBlocking


@ExperimentalCoroutinesApi
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
    @ExperimentalCoroutinesApi
    fun solve(initialValue: Boolean, source: Flow<Unit>): Flow<Boolean> {
        return source.scan(initialValue){ previousValue, _ ->
            previousValue.not()
        }
    }
}

