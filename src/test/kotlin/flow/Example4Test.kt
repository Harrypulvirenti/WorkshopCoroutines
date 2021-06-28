package flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test

class Example4Test {

    @ExperimentalCoroutinesApi
    @Test
    fun `should mix ingredients and emit correct drinks`() = runBlockingTest {
        val firstIngredientsList = flowOf(
            Ingredient.Water, Ingredient.Milk
        )
        val secondIngredientsList = flowOf(
            Ingredient.Milk, Ingredient.Coffee
        )

        val expectedResult = listOf(null, Drinks.CafeLatte())

        val actualResult = Example4.solve(firstIngredientsList,secondIngredientsList).toList()
        assert(actualResult == expectedResult)
    }
}
