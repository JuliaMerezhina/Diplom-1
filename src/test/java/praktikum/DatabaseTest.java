package praktikum;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class DatabaseTest {

    Database database = new Database();

    @Test
    public void checkDataBaseAvailableBuns() {
        List<Bun> actual = database.availableBuns();
        assertNotNull("no buns available", actual);
    }

    @Test
    public void checkDataBaseAvailableIngredients() {
        List<Ingredient> actual = database.availableIngredients();
        assertNotNull("no ingredients available", actual);
    }
}