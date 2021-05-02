package com.chocobo.shapes.repository.impl;

import com.chocobo.shapes.comparator.CubeComparator;
import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.Point;
import com.chocobo.shapes.exception.ShapeException;
import com.chocobo.shapes.repository.CubeRepository;
import com.chocobo.shapes.repository.Specification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CubeRepositoryImplTest {

    private CubeRepository repository;
    private Cube cube1;
    private Cube cube2;
    private Cube cube3;
    private Cube cube4;

    @BeforeClass
    public void setUp() throws ShapeException {
        repository = CubeRepositoryImpl.getInstance();
        repository.clear();

        cube1 = new Cube(new Point(1, 1, 4), new Point(1, 1, 1));
        cube2 = new Cube(new Point(20, 20, 100), new Point(20, 20, 50));
        cube3 = new Cube(new Point(3.4, 1123, 0), new Point(3.4, 1123, -9));
        cube4 = new Cube(new Point(230, -20, 1), new Point(230, -20, 0.5));

        repository.add(cube1);
        repository.add(cube2);
        repository.add(cube3);
        repository.add(cube4);
    }

    @DataProvider(name = "specification-provider")
    public Object[][] specificationProvider() {
        return new Object[][] {
                { new CubeIdSpecification(13), new Cube[] { cube1 } },
                { new CubeIdSpecification(15), new Cube[] { cube3 } },
                { new CubeEdgeSizeSpecification(5), new Cube[] { cube2, cube3 } },
                { new CubeEdgeSizeSpecification(30), new Cube[] { cube2 } },
                { new PointSetSpecification(new Point(20, 20, 100), new Point(20, 20, 50)),
                        new Cube[] { cube2 } },
                { new PointSetSpecification(new Point(230, -20, 1), new Point(230, -20, 0.5)),
                        new Cube[] { cube4 } }
        };
    }

    @DataProvider(name = "sort-data-provider")
    public Object[][] sortDataProvider() {
        return new Object[][] {
                { CubeComparator.ID, new Cube[] { cube1, cube2, cube3, cube4 } },
                { CubeComparator.FIRST_POINT_X, new Cube[] { cube1, cube3, cube2, cube4 } },
                { CubeComparator.FIRST_POINT_Y, new Cube[] { cube4, cube1, cube2, cube3 } },
                { CubeComparator.FIRST_POINT_Z, new Cube[] { cube3, cube4, cube1, cube2 } },
                { CubeComparator.SECOND_POINT_X, new Cube[] { cube1, cube3, cube2, cube4 } },
                { CubeComparator.SECOND_POINT_Y, new Cube[] { cube4, cube1, cube2, cube3 } },
                { CubeComparator.SECOND_POINT_Z, new Cube[] { cube3, cube4, cube1, cube2 } },
        };
    }

    @Test(dataProvider = "specification-provider")
    public void queryTest(Specification specification, Cube[] expectedArray) {
        List<Cube> actual = repository.query(specification);
        List<Cube> expected = Arrays.stream(expectedArray).collect(Collectors.toList());
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "specification-provider")
    public void queryStreamTest(Specification specification, Cube[] expectedArray) {
        List<Cube> actual = repository.query(specification);
        List<Cube> expected = Arrays.stream(expectedArray).collect(Collectors.toList());
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "sort-data-provider")
    public void sortTest(CubeComparator comparator, Cube[] expectedArray) {
        List<Cube> actual = repository.sort(comparator);
        List<Cube> expected = Arrays.stream(expectedArray).collect(Collectors.toList());
        Assert.assertEquals(actual, expected);
    }
}
