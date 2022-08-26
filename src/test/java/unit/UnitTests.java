package unit;

import org.testng.Assert;
import org.testng.annotations.Test;
import techTask.Utils;

public class UnitTests {

    @Test
    public void testArticleMoreThanTwentyFive() {
        String actualResult = Utils.getShortString("В первичных научных статьях авторами излагается существенная информация");
        String expectResult = "В первичных научных...";
        Assert.assertEquals(actualResult, expectResult);

    }

    @Test
    public void testArticleTwentyFive() {
        String actualResult = Utils.getShortString("Строка длиной 25 символов");
        String expectedResult = "Строка длиной 25 символов";
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test
    public void testArticleLessThan25() {
        String str = "Короткая строчка";
        String result = Utils.getShortString(str);
        Assert.assertEquals(result, str);
    }

    @Test
    public void testHeaderEmpty() {
        String str = "";
        String result = Utils.getShortString(str);
        Assert.assertEquals(result, str);
    }

}

