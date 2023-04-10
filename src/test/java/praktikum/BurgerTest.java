package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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

        StringBuilder testReceipt = new StringBuilder();

        testReceipt.append(String.format("(==== %s ====)%n", bunTestName));

        testReceipt.append(String.format("= %s %s =%n", ingredientTestType.toString().toLowerCase(),
                    ingredientTestName));
        testReceipt.append(String.format("= %s %s =%n", ingredientTestType.toString().toLowerCase(),
                ingredientTestName));


        testReceipt.append(String.format("(==== %s ====)%n", bunTestName));
        testReceipt.append(String.format("%nPrice: %f%n", burgerTestPrice));

        String expectedResult = testReceipt.toString();

        // создаем тестовый объект
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        // заполняем стабы для методов внутри тестируемого метода
        Mockito.when(bun.getName()).thenReturn(bunTestName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientTestType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientTestName);

        // выполняем проверку результата
        Assert.assertEquals("Ожидаемое значение Receipt не соответствует полученному", expectedResult, burger.getReceipt());

    }

    @Test
    public void setBunsTest() {

        // создаем тестовый объект
        Burger burger = new Burger();

        burger.setBuns(bun);

        Assert.assertEquals(bun, burger.bun);

    }

    @Test
    public void addIngredientTest() {

        // создаем тестовый объект
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Assert.assertFalse("Добавление новых элементов в список не выполнено", burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredientTest() {

         // создаем тестовый объект
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        burger.removeIngredient(0);

        Assert.assertTrue("Удаление элемента из спика не выполнено", burger.ingredients.isEmpty());

    }

    @Test
    public void moveIngredientTest() {

        // создаем тестовый объект
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        burger.moveIngredient(0, 1);

        Assert.assertEquals("Перемещение элемента в списке не выполнено", 2, burger.ingredients.size());

    }
}
