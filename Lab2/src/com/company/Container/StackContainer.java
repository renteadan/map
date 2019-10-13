package com.company.Container;

import com.company.Task.Task;

public class StackContainer extends AbstractContainer {

    public StackContainer() {
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
