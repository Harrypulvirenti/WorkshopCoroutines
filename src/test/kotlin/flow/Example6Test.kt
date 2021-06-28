package flow

import app.cash.turbine.test
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.time.ExperimentalTime

class Example6Test {

    @ExperimentalTime
    @ExperimentalCoroutinesApi
    @Test
    fun `should emit expected viewStates`() {
        val userEventStream = MutableSharedFlow<Unit>()

        val dispatcher = TestCoroutineDispatcher()
        runBlocking(dispatcher) {
            Example6.solve(userEventStream).test {
                userEventStream.emit(Unit)

                assertEquals(ViewState.NONE, expectItem())
                assertEquals(ViewState.IN_PROGRESS, expectItem())
                dispatcher.advanceTimeBy(DELAY_AMOUNT)
                assertEquals(ViewState.DONE, expectItem())
                cancelAndConsumeRemainingEvents()
            }
        }
    }
}