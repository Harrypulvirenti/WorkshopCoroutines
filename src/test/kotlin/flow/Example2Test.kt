package flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class Example2Test {

    @ExperimentalCoroutinesApi
    @Test
    fun `should emit only positive numbers`() = runBlockingTest {
        val testNumbers = listOf(3, 1, -3, -44, -1, 9, 8, -9)
        val expectedResult = listOf(3, 1, 9, 8)

        val actualResult = Example2.solve(testNumbers).toList()
        assert(actualResult == expectedResult)
    }
}
