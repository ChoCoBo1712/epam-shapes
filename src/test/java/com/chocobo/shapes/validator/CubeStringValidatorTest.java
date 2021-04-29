package com.chocobo.shapes.validator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubeStringValidatorTest {

    @DataProvider(name = "string-provider")
    public Object[][] stringProvider() {
        return new Object[][] {
                { "1.0, 2, 3.3, 4, 5", true },
                { "-1.0", true },
                { "+1.1", true },
                { "a1.0, 2, 3.3, 4, 5", false },
                { ":1.0, 2, 3.3, 4, 5", false }
        };
    }

    @Test(dataProvider = "string-provider")
    public void isValidStringTest(String string, boolean expected) {
        boolean actual = CubeStringValidator.isValidString(string);
        Assert.assertEquals(actual, expected);
    }
}
