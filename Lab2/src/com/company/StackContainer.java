package com.company;

import java.util.Arrays;

public class StackContainer extends AbstarctContainer {

    StackContainer() {
        arr = new Task[2];
        size = 0;
    }

    @Override
    public Task remove() {
        if(size==0)
            return null;
        size--;
        return arr[size];
    }

    @Override
    public void add(Task task) {
        if(size == arr.length) {
            resize();
        }
        arr[size] = task;
        size++;
    }
}
