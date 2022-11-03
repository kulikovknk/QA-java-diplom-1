package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTest {

    @Test
    public void getNameTest() {

        String ingredientTestName = "ingredientTestName";
        float ingredientTestPrice = 2.4F;
        IngredientType ingredientTestType = IngredientType.SAUCE;

        Ingredient ingredient = new Ingredient(ingredientTestType, ingredientTestName, ingredientTestPrice);

        Assert.assertEquals(ingredientTestName, ingredient.getName());

    }

    @Test
    public void getPriceTest() {

        String ingredientTestName = "ingredientTestName";
        float ingredientTestPrice = 2.4F;
        IngredientType ingredientTestType = IngredientType.SAUCE;

        Ingredient ingredient = new Ingredient(ingredientTestType, ingredientTestName, ingredientTestPrice);

        Assert.assertEquals(ingredientTestPrice, ingredient.getPrice(), 0);

    }

    @Test
    public void getTypeTest() {

        String ingredientTestName = "ingredientTestName";
        float ingredientTestPrice = 2.4F;
        IngredientType ingredientTestType = IngredientType.SAUCE;

        Ingredient ingredient = new Ingredient(ingredientTestType, ingredientTestName, ingredientTestPrice);

        Assert.assertEquals(ingredientTestType, ingredient.getType());

    }


}
