package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;

    @Test
    public void getReceiptTest() {

        // заполняем тестовые данные
        String bunTestName = "bunTestName";
        String ingredientTestName = "ingredientTestName";

        IngredientType ingredientTestType = IngredientType.SAUCE;

        float burgerTestPrice = 0.0F;

        List<Ingredient> ingredients = new ArrayList<>();

        ingredients.add(ingredient);
        ingredients.add(ingredient);

        StringBuilder testReceipt = new StringBuilder();

        testReceipt.append(String.format("(==== %s ====)%n", bunTestName));

        for (Ingredient i : ingredients) {
            testReceipt.append(String.format("= %s %s =%n", ingredientTestType.toString().toLowerCase(),
                    ingredientTestName));
        }

        testReceipt.append(String.format("(==== %s ====)%n", bunTestName));
        testReceipt.append(String.format("%nPrice: %f%n", burgerTestPrice));

        String expectedResult = testReceipt.toString();

        // создаем тестовый объект
        Burger burger = new Burger(bun, ingredients);

        // заполняем стабы для методов внутри тестируемого метода
        Mockito.when(bun.getName()).thenReturn(bunTestName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientTestType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientTestName);

        // выполняем проверку результата
        Assert.assertEquals("Ожидаемое значение Receipt не соответствует полученному", expectedResult, burger.getReceipt());

    }

    @Test
    public void setBunsTest() {

        List<Ingredient> ingredients = new ArrayList<>();

        // создаем тестовый объект
        Burger burger = new Burger(bun, ingredients);

        burger.setBuns(bun);

        Assert.assertEquals(bun, burger.bun);

    }

    @Test
    public void addIngredientTest() {

        List<Ingredient> ingredients = new ArrayList<>();

        // создаем тестовый объект
        Burger burger = new Burger(bun, ingredients);

        burger.addIngredient(ingredient);

        Assert.assertFalse("Добавление новых элементов в список не выполнено", burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredientTest() {

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);

        // создаем тестовый объект
        Burger burger = new Burger(bun, ingredients);

        burger.removeIngredient(0);

        Assert.assertTrue("Удаление элемента из спика не выполнено", burger.ingredients.isEmpty());

    }

    @Test
    public void moveIngredientTest() {

        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        ingredients.add(ingredient);

        // создаем тестовый объект
        Burger burger = new Burger(bun, ingredients);

        burger.moveIngredient(0, 1);

        Assert.assertEquals("Перемещение элемента в списке не выполнено", 2, burger.ingredients.size());

    }
}
