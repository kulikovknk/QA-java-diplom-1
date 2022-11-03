package praktikum;

import org.junit.Assert;
import org.junit.Test;

public class BunTest {

    @Test
    public void getNameTest() {

        String bunTestName = "bunTestName";
        float bunTestPrice = 5.5F;

        Bun bun = new Bun(bunTestName, bunTestPrice);

        Assert.assertEquals(bunTestName, bun.getName());

    }

    @Test
    public void getPriceTest() {

        String bunTestName = "bunTestName";
        float bunTestPrice = 5.5F;

        Bun bun = new Bun(bunTestName, bunTestPrice);

        Assert.assertEquals(bunTestPrice, bun.getPrice(), 0);

    }

}
