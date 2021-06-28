package flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class Example3Test {

    @ExperimentalCoroutinesApi
    @Test
    fun `should negate value previously emitted by your flow`() = runBlockingTest {
        val testEventsStream = flowOf(Unit, Unit, Unit)
        val initValue = true
        val expectedResult = listOf(true, false, true, false)

        val actualResult = Example3.solve(initValue, testEventsStream).toList()
        assert(actualResult == expectedResult)
    }
}
