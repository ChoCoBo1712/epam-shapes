package com.chocobo.shapes.repository.impl;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.CubeParameter;
import com.chocobo.shapes.exception.ShapeException;
import com.chocobo.shapes.repository.Specification;
import com.chocobo.shapes.service.CubeCalculationService;
import com.chocobo.shapes.service.impl.CubeCalculationServiceImpl;
import com.chocobo.shapes.warehouse.CubeWarehouse;
import com.chocobo.shapes.warehouse.impl.CubeWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CubeVolumeSpecification implements Specification {

    private static final Logger logger = LogManager.getLogger();
    private final double volume;

    public CubeVolumeSpecification(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean specify(Cube cube) {
        CubeWarehouse warehouse = CubeWarehouseImpl.getInstance();
        if (cube == null) {
            return false;
        }

        double volume = warehouse.get(cube.getCubeId())
                .map(CubeParameter::getVolume)
                .orElseGet(() -> {
                    CubeCalculationService service = new CubeCalculationServiceImpl();
                    try {
                        return service.calculateVolume(cube);
                    } catch (ShapeException e) {
                        logger.error("Volume calculation error: ", e);
                        return 0d;
                    }
                });
        return Double.compare(volume, this.volume) == 0;
    }
}
