package org.sadovodBase.service;

public class CounterService {

    private int counter = 0;

    public int increment() {
        counter++;
        return counter;
    }

    public int getValue() {
        return counter;
    }
}