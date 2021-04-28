package com.chocobo.shapes.initializer;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.repository.CubeRepository;
import com.chocobo.shapes.repository.impl.CubeRepositoryImpl;

public class CubeRepositoryInitializer {

    public void fillRepositoryWithCube(Cube cube) {
        CubeRepository repository = CubeRepositoryImpl.getInstance();
        repository.add(cube);
    }
}
