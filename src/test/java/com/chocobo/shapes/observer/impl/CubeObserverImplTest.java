package com.chocobo.shapes.observer.impl;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.CubeParameter;
import com.chocobo.shapes.entity.Point;
import com.chocobo.shapes.exception.ShapeException;
import com.chocobo.shapes.initializer.CubeRepositoryInitializer;
import com.chocobo.shapes.initializer.CubeWarehouseInitializer;
import com.chocobo.shapes.warehouse.CubeWarehouse;
import com.chocobo.shapes.warehouse.impl.CubeWarehouseImpl;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CubeObserverImplTest {

    @Test
    public void parametersChangedTest() throws ShapeException {
        Cube cube = new Cube(new Point(1, 1, 4), new Point(1, 1, 1));
        CubeRepositoryInitializer repositoryInitializer = new CubeRepositoryInitializer();
        CubeWarehouseInitializer warehouseInitializer = new CubeWarehouseInitializer();
        repositoryInitializer.fillRepositoryWithCube(cube, new CubeObserverImpl());
        warehouseInitializer.fillWarehouseWithCube(cube);
        CubeWarehouse warehouse = CubeWarehouseImpl.getInstance();

        CubeParameter oldParameter = warehouse.get(cube.getCubeId()).orElse(new CubeParameter()).clone();
        cube.setSecondPoint(new Point(1, 1, 2));
        CubeParameter newParameter = warehouse.get(cube.getCubeId()).orElse(new CubeParameter()).clone();
        Assert.assertNotEquals(oldParameter, newParameter);
    }
}
