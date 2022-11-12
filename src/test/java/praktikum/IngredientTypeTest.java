package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class IngredientTypeTest {

    private final String INGREDIENT_TYPE_SAUCE = "SAUCE";
    private final String INGREDIENT_TYPE_FILLING = "FILLING";


    @Test
    public void checkIngredientTypeSAUCE() {
        Assert.assertEquals(INGREDIENT_TYPE_SAUCE, IngredientType.SAUCE.name());
    }

    @Test
    public void checkIngredientTypeFILLING() {
        Assert.assertEquals(INGREDIENT_TYPE_FILLING, IngredientType.FILLING.name());
    }
}
