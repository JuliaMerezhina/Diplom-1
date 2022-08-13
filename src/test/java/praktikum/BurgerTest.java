package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    Burger burger = new Burger();

    Ingredient testIngredient = new Ingredient(SAUCE, "арахисовый", 1000);

    Bun newBun = new Bun("newBun", 750);

    @Test
    public void setBurgerBuns() {
        burger.setBuns(bun);
        assertEquals("error: bun selection failed", burger.bun, bun);
    }

    @Test
    public void BurgerAddIngredient() {
        burger.addIngredient(ingredient);
        assertNotNull("error: failed to add ingredient", burger.ingredients);
    }

    @Test
    public void BurgerRemovedIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertTrue("error: failed to remove ingredient", burger.ingredients.isEmpty());
    }

    @Test
    public void BurgerMoveIngredient() {
        burger.addIngredient(ingredient);
        burger.addIngredient(testIngredient);
        burger.moveIngredient(0, 1);
        assertEquals("error: failed to move ingredient", "арахисовый", testIngredient.name);
    }

    @Test
    public void BurgerGetPrice() {
        burger.setBuns(newBun);
        burger.addIngredient(testIngredient);
        Float actualPrice = burger.getPrice();
        Float expectedPrice = newBun.price * 2 + testIngredient.price;
        assertEquals("error: price received does not match expected", expectedPrice, actualPrice);
    }

    @Test
    public void BurgerGetReceipt() {
        burger.setBuns(newBun);
        //Добавить ингредиент
        burger.addIngredient(testIngredient);
        //Получить чек
        String actualReceipt = burger.getReceipt();
        String newPrice = String.format("%.6f", burger.getPrice());

        String expectedReceipt = String.format(
                "(==== %s ====)%n= %s %s =%n(==== %s ====)%n%nPrice: %s%n",
                newBun.name,
                testIngredient.type.toString().toLowerCase(),
                testIngredient.name,
                newBun.name,
                newPrice);

        assertEquals("error: recipe not expected", expectedReceipt, actualReceipt);
    }
}