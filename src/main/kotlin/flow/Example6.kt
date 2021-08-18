package flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


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
     * When you receive a new [userActionFlow] emission, return a [StateFlow<ViewState>] that represents
     * the state of the view. It should run on a separate Dispatcher and first be at [ViewState.NONE] then [ViewState.IN_PROGRESS]
     * with a [DELAY_AMOUNT] then [ViewState.DONE].
     */
    fun solve(userActionFlow: SharedFlow<Unit>): StateFlow<ViewState> {
        val viewState = MutableStateFlow(ViewState.NONE)
        CoroutineScope(Dispatchers.Default).launch {
            userActionFlow.collect {
                viewState.emit(ViewState.IN_PROGRESS)
                delay(DELAY_AMOUNT)
                viewState.emit(ViewState.DONE)
            }
        }
        return viewState
    }
}

enum class ViewState {
    NONE, IN_PROGRESS, DONE
}

const val DELAY_AMOUNT = 500L
