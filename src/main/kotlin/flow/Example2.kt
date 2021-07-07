package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

val testNumbers = listOf(1, 0, 3, -9, -5, 11, 98, 3, 0, -9)
fun main() = runBlocking {
    Example2.solve(testNumbers).collect { value -> println(value) }
}

object Example2 {
    /**
     * Given a list of [numbers] that contains positive, negative and 0 numbers.
     * Only emit the positive numbers.
     */
    fun solve(numbers: List<Int>): Flow<Int> {
        return numbers.filter { it > 0 }.asFlow()
    }
}