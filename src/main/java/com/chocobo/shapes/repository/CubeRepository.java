package com.chocobo.shapes.repository;

import com.chocobo.shapes.entity.Cube;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface CubeRepository {

    boolean add(Cube item);
    boolean remove(Cube item);
    boolean addAll(Collection<? extends Cube> items);
    boolean removeAll(Collection<? extends Cube> items);
    void clear();
    List<Cube> query(Specification specification);
    List<Cube> queryStream(Specification specification);
    List<Cube> sort(Comparator<? super Cube> comparator);
}
