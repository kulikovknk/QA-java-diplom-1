package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

@RunWith(Parameterized.class)
public class BurgerParamTest {

    private final Bun bun = Mockito.mock(Bun.class);
    private final Ingredient ingredient = Mockito.mock(Ingredient.class);

    @Parameterized.Parameters(name = "{index}: bunPrice: {0}, ingredientPrice: {1}, expectedResult: {2}")
    public static Object[][] data() {
        return new Object[][] {
                { 5.5F, 2.4F, 15.8F },
                { 4.23F, 1.15F, 10.76F },
                { 0.0F, 0.0F, 0.0F },
        };
    }

    @Parameterized.Parameter(0)
    public float bunTestPrice;

    @Parameterized.Parameter(1)
    public float ingredientTestPrice;

    @Parameterized.Parameter(2)
    public float expectedResult;

    @Test
    public void getPriceTest() {

        List<Ingredient> ingredients = new ArrayList<>();

        ingredients.add(ingredient);
        ingredients.add(ingredient);

        Burger burger = new Burger(bun, ingredients);

        Mockito.when(bun.getPrice()).thenReturn(bunTestPrice);
        Mockito.when(ingredients.get(0).getPrice()).thenReturn(ingredientTestPrice);

        Assert.assertEquals(expectedResult, burger.getPrice(), 0.001);

    }

}
