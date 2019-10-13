package com.company;

import java.util.Arrays;

public class QueueContainer extends AbstarctContainer{

    QueueContainer() {
        arr = new Task[2];
        size = 0;
    }
    @Override
    public Task remove() {
        if(size==0)
            return null;
        size--;
        Task temp = arr[0];
        if (size >= 0) System.arraycopy(arr, 1, arr, 0, size);
        return temp;
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
