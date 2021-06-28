package flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class Example1Test {

    @ExperimentalCoroutinesApi
    @Test
    fun `should emit numbers from 0 to 10`() = runBlockingTest {
        val expectedResult = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        Example1.solve().collect { currentNumber ->
            advanceTimeBy(DELAY_AMOUNT)
            assert(currentNumber == expectedResult[currentNumber])
        }
    }
}
