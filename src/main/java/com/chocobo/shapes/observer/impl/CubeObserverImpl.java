package com.chocobo.shapes.observer.impl;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.CubeParameters;
import com.chocobo.shapes.exception.ShapeException;
import com.chocobo.shapes.observer.CubeEvent;
import com.chocobo.shapes.observer.CubeObserver;
import com.chocobo.shapes.service.CubeCalculationService;
import com.chocobo.shapes.service.impl.CubeCalculationServiceImpl;
import com.chocobo.shapes.warehouse.CubeWarehouse;
import com.chocobo.shapes.warehouse.impl.CubeWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CubeObserverImpl implements CubeObserver {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void parametersChanged(CubeEvent event) {
        Cube cube = event.getSource();
        CubeCalculationService calculationService = new CubeCalculationServiceImpl();
        CubeWarehouse warehouse = CubeWarehouseImpl.getInstance();

        Long cubeId = cube.getCubeId();
        try {
            double perimeter = calculationService.findPerimeter(cube);
            double area = calculationService.findArea(cube);
            double volume = calculationService.findVolume(cube);
            CubeParameters newParameters = new CubeParameters(perimeter, area, volume);
            warehouse.put(cubeId, newParameters);
        } catch (ShapeException e) {
            logger.error("Warehouse is not updated. Cause: ", e.getCause());
        }
    }
}
