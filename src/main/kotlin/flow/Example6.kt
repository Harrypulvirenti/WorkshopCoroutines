package flow

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    val userActionFlow = MutableSharedFlow<Unit>(replay = 1)
    userActionFlow.emit(Unit)

    Example6
        .solve(userActionFlow)
        .collect { value ->
            println(value)
        }
}

object Example6 {

    /**
     * When the you receive a new [userActionFlow] emit return a [StateFlow<ViewState>] that represents
     * the state of the view. It should at first be at [ViewState.NONE] then [ViewState.IN_PROGRESS]
     * for the [DELAY_AMOUNT] then [ViewState.DONE].
     */
    suspend fun solve(userActionFlow: SharedFlow<Unit>): StateFlow<ViewState> {
       TODO()
    }
}

enum class ViewState {
    NONE, IN_PROGRESS, DONE
}

const val DELAY_AMOUNT = 500L