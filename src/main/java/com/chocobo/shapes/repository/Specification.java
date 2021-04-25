package com.chocobo.shapes.repository;

import com.chocobo.shapes.entity.Cube;

public interface Specification {

    boolean specify(Cube cube);
}
