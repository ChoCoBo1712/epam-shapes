package com.chocobo.shapes.initializer;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.exception.ShapeException;
import com.chocobo.shapes.service.CubeCalculationService;
import com.chocobo.shapes.service.impl.CubeCalculationServiceImpl;
import com.chocobo.shapes.warehouse.CubeWarehouse;
import com.chocobo.shapes.warehouse.impl.CubeWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeWarehouseInitializer {

    private static final Logger logger = LogManager.getLogger();

    public void addCubeToWarehouse(Cube cube) {
        CubeWarehouse warehouse = CubeWarehouseImpl.getInstance();
        CubeCalculationService service = new CubeCalculationServiceImpl();

        try {
            double perimeter = service.calculatePerimeter(cube);
            double area = service.calculateArea(cube);
            double volume = service.calculateVolume(cube);
            warehouse.put(cube.getCubeId(), perimeter, area, volume);
        } catch (ShapeException e) {
            logger.error("An attempt to fill warehouse with invalid cube: " + cube, e);
        }

    }
}
