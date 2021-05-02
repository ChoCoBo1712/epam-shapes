package com.chocobo.shapes.reader;

import com.chocobo.shapes.exception.ShapeException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CubePointsReaderTest {

    private final CubePointsReader fileReader = new CubePointsReader();

    @Test
    public void readLinesToListTest() throws ShapeException {
        List<String> actual = fileReader.readLinesToList("data/pointsTest.txt");

        List<String> expected = Arrays.asList("1, 1, 10, 1, 1, -1", "2.0, 3, 4, 2.0, 3, 0.1", "1, 9, 12.0, 1, 9, 3");
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ShapeException.class)
    public void readLinesToListExceptionTest() throws ShapeException {
        fileReader.readLinesToList("data/pointTest.txt");
    }
}
