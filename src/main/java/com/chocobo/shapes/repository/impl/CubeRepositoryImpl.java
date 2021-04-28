package com.chocobo.shapes.repository.impl;

import com.chocobo.shapes.entity.Cube;
import com.chocobo.shapes.repository.CubeRepository;
import com.chocobo.shapes.repository.Specification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CubeRepositoryImpl implements CubeRepository {

    private static CubeRepository instance = null;
    private final List<Cube> collection;

    private CubeRepositoryImpl() {
        collection = new ArrayList<>();
    }

    public static CubeRepository getInstance() {
        if (instance == null) {
            instance = new CubeRepositoryImpl();
        }

        return instance;
    }

    @Override
    public boolean add(Cube cube) {
        return collection.add(cube);
    }

    @Override
    public boolean remove(Cube cube) {
        return collection.remove(cube);
    }

    @Override
    public boolean addAll(Collection<? extends Cube> cubes) {
        return collection.addAll(cubes);
    }

    @Override
    public boolean removeAll(Collection<? extends Cube> cubes) {
        return collection.removeAll(cubes);
    }

    @Override
    public List<Cube> query(Specification specification) {
        List<Cube> queryResult = new ArrayList<>();
        for (Cube cube : collection) {
            if (specification.specify(cube)) {
                queryResult.add(cube);
            }
        }
        return queryResult;
    }

    @Override
    public List<Cube> queryStream(Specification specification) {
        return collection.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }
}
