package com.chocobo.shapes.parser;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubePointsParserTest {

    @DataProvider(name = "string-provider")
    public Object[][] stringProvider() {
        return new Object[][] {
                { "1.0, 2, 3.3, 4, 5", new double[] { 1.0, 2, 3.3, 4, 5 } },
                { "1, +1, 2, 2", new double[] { 1, 1, 2, 2 } },
                { "2.0, -5, 6, 4, 0.0, 0.0", new double[] { 2, -5, 6, 4, 0, 0 }  },
                { "3, 4, 100.1, 5", new double[] { 3, 4, 100.1, 5 } },
                { "1.3, 17, -1.554, 1.6", new double[] { 1.3, 17, -1.554, 1.6 } }
        };
    }

    @Test(dataProvider = "string-provider")
    public void parseTest(String line, double[] expected) {
        CubePointsParser parser = new CubePointsParser();
        double[] actual = parser.parse(line);
        Assert.assertEquals(actual, expected);
    }
}
