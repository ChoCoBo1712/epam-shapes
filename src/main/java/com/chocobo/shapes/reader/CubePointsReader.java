package com.chocobo.shapes.reader;

import com.chocobo.shapes.exception.ShapeException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CubePointsReader {

    public List<String> readLinesToList(String filePath) throws ShapeException {
        try {
            return Files.lines(Path.of(ClassLoader.getSystemResource(filePath).toURI()))
                    .collect(Collectors.toList());
        } catch (IOException | URISyntaxException | NullPointerException e) {
            throw new ShapeException(e);
        }
    }
}
