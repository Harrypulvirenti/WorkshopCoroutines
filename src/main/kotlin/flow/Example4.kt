package flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val firstIngredientsList = listOf(
        Ingredient.Water, Ingredient.Milk, Ingredient.Banana, Ingredient.Chocolate
    )
    val secondIngredientsList = listOf(
        Ingredient.Coffee, Ingredient.Water, Ingredient.Coffee, Ingredient.Milk
    )

    Example4.solve(
        firstIngredientsList, secondIngredientsList
    ).collect { value ->
        println(value)
    }
}

object Example4 {

    /**
     * Having a 2 lists of [Ingredient] as input
     * mix the ingredient if possible then return a flow of [Drinks]
     * if not possible emit null.
     */
    fun solve(
        firstIngredients: List<Ingredient>,
        secondIngredients: List<Ingredient>
    ): Flow<Drinks?> {
        TODO()
    }
}

sealed class Ingredient {
    object Milk : Ingredient()
    object Coffee : Ingredient()
    object Water : Ingredient()
    object Banana : Ingredient()
    object Chocolate : Ingredient()
}

sealed class Drinks {
    data class CafeLatte(
        val firstIngredient: Ingredient.Milk,
        val secondIngredient: Ingredient.Coffee
    ) :
        Drinks()

    data class Espresso(
        val firstIngredient: Ingredient.Water,
        val secondIngredient: Ingredient.Coffee
    ) :
        Drinks()

    data class HotChocolate(
        val firstIngredient: Ingredient.Milk,
        val secondIngredient: Ingredient.Chocolate
    ) :
        Drinks()

    data class BananaMilkshake(
        val firstIngredient: Ingredient.Milk,
        val secondIngredient: Ingredient.Banana
    ) :
        Drinks()

}