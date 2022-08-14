package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    public IngredientType ingredientType;

    public String expectedIngredientType;

    public IngredientTypeTest(String expectedIngredientName, IngredientType ingredientType) {
        this.ingredientType = ingredientType;
        this.expectedIngredientType = expectedIngredientName;
    }

    @Parameterized.Parameters
    public static Object[][] getEnum() {
        return new Object[][]{
                {"SAUCE", IngredientType.SAUCE},
                {"FILLING", IngredientType.FILLING}
        };
    }

    @Test
    public void enumIngredientType() {
        String actualIngredientName = ingredientType.name();
        assertEquals(expectedIngredientType, actualIngredientName);
    }
}