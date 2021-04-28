package com.chocobo.shapes.observer;

public interface EllipseObservable {

    void attachObserver(CubeObserver observer);
    void detachObserver();
    void notifyObserver();
}
