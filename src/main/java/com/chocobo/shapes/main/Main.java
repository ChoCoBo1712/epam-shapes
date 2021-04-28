package com.chocobo.shapes.main;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.exception.ShapeException;
import com.chocobo.shapes.factory.CubeFactory;
import com.chocobo.shapes.parser.CubePointsParser;
import com.chocobo.shapes.reader.CubePointsReader;
import com.chocobo.shapes.repository.CubeRepository;
import com.chocobo.shapes.repository.impl.CubeRepositoryImpl;
import com.chocobo.shapes.validator.CubeStringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static final String FILE_PATH = "data/test.txt";
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        CubePointsReader reader = new CubePointsReader();
        CubePointsParser parser = new CubePointsParser();
        CubeRepository repository = CubeRepositoryImpl.getInstance();

        try {
            List<double[]> pointsArrays = reader.readLinesToList(FILE_PATH).stream()
                    .filter(CubeStringValidator::isValidString)
                    .map(parser::parse)
                    .collect(Collectors.toList());
            for (double[] pointsArray : pointsArrays) {
                Cube cube = CubeFactory.createCube(pointsArray);
                repository.add(cube);
            }
            int a = 0;
        } catch (ShapeException e) {
            logger.error("Unexpected exception: ", e);
        }
    }
}
