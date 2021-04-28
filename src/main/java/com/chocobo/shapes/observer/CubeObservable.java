package com.chocobo.shapes.observer;

public interface CubeObservable {

    void attachObserver(CubeObserver observer);
    void detachObserver();
    void notifyObserver();
}
