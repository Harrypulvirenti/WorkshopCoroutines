package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val firstIngredientsList = flowOf(
        Ingredient.Water, Ingredient.Water, Ingredient.Milk
    )
    val secondIngredientsList = flowOf(
        Ingredient.Coffee, Ingredient.Milk, Ingredient.Chocolate
    )

    Example4.solve(
        firstIngredientsList, secondIngredientsList
    ).collect { value ->
        println(value)
    }
}

object Example4 {

    /**
     * Having a 2 lists of [Ingredient] as inputs
     * mix the ingredient if possible then return a flow of [Drinks]
     * if not possible emit null.
     */
    fun solve(
        firstIngredients: Flow<Ingredient>,
        secondIngredients: Flow<Ingredient>
    ): Flow<Drinks?> {
        TODO()
    }
}

sealed class Ingredient {
    object Milk : Ingredient()
    object Coffee : Ingredient()
    object Water : Ingredient()
    object Chocolate : Ingredient()
}

sealed class Drinks {
    data class CafeLatte(
        val firstIngredient: Ingredient = Ingredient.Milk,
        val secondIngredient: Ingredient = Ingredient.Coffee
    ) :
        Drinks()

    data class Espresso(
        val firstIngredient: Ingredient = Ingredient.Water,
        val secondIngredient: Ingredient = Ingredient.Coffee
    ) :
        Drinks()

    data class HotChocolate(
        val firstIngredient: Ingredient = Ingredient.Milk,
        val secondIngredient: Ingredient = Ingredient.Chocolate
    ) :
        Drinks()

    companion object {
        // Checks if the ingredients can be mixed or not
        fun makeDrinkIfPossible(
            firstIngredient: Ingredient,
            secondIngredient: Ingredient
        ) = when {
            firstIngredient is Ingredient.Milk && secondIngredient is Ingredient.Coffee -> CafeLatte(
                firstIngredient,
                secondIngredient
            )
            firstIngredient is Ingredient.Water && secondIngredient is Ingredient.Coffee -> Espresso(
                firstIngredient,
                secondIngredient
            )
            firstIngredient is Ingredient.Milk && secondIngredient is Ingredient.Chocolate -> HotChocolate(
                firstIngredient,
                secondIngredient
            )
            else -> null
        }
    }
}