package com.chocobo.shapes.observer;

public interface Observable {

    void attachObserver(CubeObserver observer);
    void detachObserver();
    void notifyObserver();
}
