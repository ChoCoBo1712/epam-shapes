package com.chocobo.shapes.main;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.entity.CubeParameter;
import com.chocobo.shapes.entity.Point;
import com.chocobo.shapes.exception.ShapeException;
import com.chocobo.shapes.factory.CubeFactory;
import com.chocobo.shapes.initializer.CubeRepositoryInitializer;
import com.chocobo.shapes.initializer.CubeWarehouseInitializer;
import com.chocobo.shapes.observer.impl.CubeObserverImpl;
import com.chocobo.shapes.parser.CubePointsParser;
import com.chocobo.shapes.reader.CubePointsReader;
import com.chocobo.shapes.repository.CubeRepository;
import com.chocobo.shapes.repository.impl.CubeIdSpecification;
import com.chocobo.shapes.repository.impl.CubeRepositoryImpl;
import com.chocobo.shapes.validator.CubeStringValidator;
import com.chocobo.shapes.warehouse.CubeWarehouse;
import com.chocobo.shapes.warehouse.impl.CubeWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final String FILE_PATH = "data/points.txt";
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            CubePointsReader reader = new CubePointsReader();
            CubePointsParser parser = new CubePointsParser();
            CubeRepositoryInitializer repositoryInitializer = new CubeRepositoryInitializer();
            CubeWarehouseInitializer warehouseInitializer = new CubeWarehouseInitializer();

            List<double[]> pointsArrays = reader.readLinesToList(FILE_PATH).stream()
                    .filter(CubeStringValidator::isValidString)
                    .map(parser::parse)
                    .collect(Collectors.toList());
            for (double[] pointsArray : pointsArrays) {
                Cube cube = CubeFactory.createCube(pointsArray);
                cube.attachObserver(new CubeObserverImpl());
                repositoryInitializer.fillRepositoryWithCube(cube);
                warehouseInitializer.fillWarehouseWithCube(cube);
            }

            CubeRepository repository = CubeRepositoryImpl.getInstance();
            List<Cube> queryResult = repository.query(new CubeIdSpecification(1));
            Cube cube = queryResult.get(0);

            CubeWarehouse warehouse = CubeWarehouseImpl.getInstance();
            CubeParameter parameter = warehouse.get(cube.getCubeId()).orElse(new CubeParameter());

            logger.info("Old area: " + parameter.getArea() + ", old perimeter: " + parameter.getPerimeter()
                    + ", old volume: " + parameter.getVolume());
            cube.setFirstPoint(new Point(1, 1, 1));
            logger.info("New area: " + parameter.getArea() + ", new perimeter: " + parameter.getPerimeter()
                    + ", new volume: " + parameter.getVolume());
        } catch (ShapeException e) {
            logger.error("Unexpected exception: ", e);
        }
    }
}
