package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    public String name;
    public float price;
    public IngredientType type;

    public IngredientTest(String name, float price, IngredientType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredient() {
        return new Object[][]{
                {"Сыр c астероидной плесенью", 4142, IngredientType.FILLING},
                {"Соус традиционный галактический", 15, IngredientType.SAUCE},
                {"Соус фирменный Space Sauce", 80, IngredientType.SAUCE}
        };
    }

    @Test
    public void getPriceCheckUp() {
        Ingredient ingredient = new Ingredient(type, name, price);
        float actualPrice = ingredient.getPrice();
        assertEquals(price, actualPrice, 0);
    }

    @Test
    public void getNameCheckUp() {
        Ingredient ingredient = new Ingredient(type, name, price);
        String actualName = ingredient.getName();
        assertEquals(name, actualName);
    }

    @Test
    public void getTypeCheckUp() {
        Ingredient ingredient = new Ingredient(type, name, price);
        IngredientType actualType = ingredient.getType();
        assertEquals(type, actualType);
    }
}