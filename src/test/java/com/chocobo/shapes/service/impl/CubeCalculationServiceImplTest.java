package com.chocobo.shapes.service.impl;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.Point;
import com.chocobo.shapes.exception.ShapeException;
import com.chocobo.shapes.service.CubeCalculationService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CubeCalculationServiceImplTest {

    private CubeCalculationService service = new CubeCalculationServiceImpl();

    @DataProvider(name = "cube-perimeter-provider")
    public Object[][] cubePerimeterProvider() throws ShapeException {
        return new Object[][] {
                { new Cube(new Point(1, 1, 4), new Point(1, 1, 1)), 36 },
                { new Cube(new Point(20, 20, 100), new Point(20, 20, 50)), 600 }
        };
    }

    @DataProvider(name = "cube-area-provider")
    public Object[][] cubeAreaProvider() throws ShapeException {
        return new Object[][] {
                { new Cube(new Point(1, 1, 4), new Point(1, 1, 1)), Math.pow(3, 2) * 6 },
                { new Cube(new Point(20, 20, 100), new Point(20, 20, 50)), Math.pow(50, 2) * 6 }
        };
    }

    @DataProvider(name = "cube-volume-provider")
    public Object[][] cubeVolumeProvider() throws ShapeException {
        return new Object[][] {
                { new Cube(new Point(1, 1, 4), new Point(1, 1, 1)), Math.pow(3, 3) },
                { new Cube(new Point(20, 20, 100), new Point(20, 20, 50)), Math.pow(50, 3) }
        };
    }

    @Test(dataProvider = "cube-perimeter-provider")
    public void calculatePerimeterTest(Cube cube, double expected) throws ShapeException {
        double actual = service.calculatePerimeter(cube);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "cube-area-provider")
    public void calculateAreaTest(Cube cube, double expected) throws ShapeException {
        double actual = service.calculateArea(cube);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "cube-volume-provider")
    public void calculateVolumeTest(Cube cube, double expected) throws ShapeException {
        double actual = service.calculateVolume(cube);
        Assert.assertEquals(actual, expected);
    }
}
