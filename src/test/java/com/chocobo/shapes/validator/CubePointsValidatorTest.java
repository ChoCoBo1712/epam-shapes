package com.chocobo.shapes.validator;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.Point;
import com.chocobo.shapes.exception.ShapeException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubePointsValidatorTest {

    @DataProvider(name = "cube-provider")
    public Object[][] cubeProvider() throws ShapeException {
        return new Object[][] {
                { new Cube(new Point(1, 1, 3), new Point(1, 1, 1)), true },
                { new Cube(new Point(-1.0, 100, 150), new Point(-1, 100.0, 149.99)), true },
                { new Cube(new Point(-3, -1, 3), new Point(-1, -1, -1)), false },
                { new Cube(new Point(1, 1, 1), new Point(1, 1, 1)), false },
                { new Cube(new Point(100, 18, 1), new Point(100, 18, 3)), false },
                { new Cube(new Point(-1, -1, -3), new Point(-1, -1, -1)), false }
        };
    }

    @Test(dataProvider = "cube-provider")
    public void isValidCubeTest(Cube cube, boolean expected) {
        boolean actual = CubePointsValidator.isValidCube(cube);
        Assert.assertEquals(actual, expected);
    }
}
