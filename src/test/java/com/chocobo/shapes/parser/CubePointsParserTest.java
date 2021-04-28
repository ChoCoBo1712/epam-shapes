package com.chocobo.shapes.parser;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CubePointsParserTest {

    @Test
    public void parseTest() {
        CubePointsParser parser = new CubePointsParser();
        double[] expected = new double[]{1.0, 2, 3.3, 4, 5};
        double[] actual = parser.parse("1.0, 2, 3.3, 4, 5");
        Assert.assertEquals(actual, expected);
    }
}
