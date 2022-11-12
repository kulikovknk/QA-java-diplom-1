package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class BurgerParamTest {

    private final Bun bun = Mockito.mock(Bun.class);
    private final Ingredient ingredient = Mockito.mock(Ingredient.class);

    @Parameterized.Parameters(name = "{index}: bunPrice: {0}, ingredientPrice: {1}, expectedResult: {2}")
    public static Object[][] data() {
        return new Object[][] {
                { 5.5F, 2.4F, 15.8F },
                { 0.0F, 0.0F, 0.0F },
                { 4.23F, 0.0F, 8.46F },
                { 0.0F, 1.15F, 2.3F },
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

        // создаем тестовый объект
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(bunTestPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientTestPrice);

        Assert.assertEquals(expectedResult, burger.getPrice(), 0.001);

    }

}
