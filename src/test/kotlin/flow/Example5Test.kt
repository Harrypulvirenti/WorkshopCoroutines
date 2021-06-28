package flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class Example5Test {

    @ExperimentalCoroutinesApi
    @Test
    fun `should emit numbers 1 and 2 then stop at 3`() = runBlockingTest {
        val expectedResult = listOf(1,2)

        val actualResult = Example5.solve().toList()
        assert(actualResult == expectedResult)
    }
}