package com.company.Container;

import com.company.Task.Task;
import java.util.Arrays;

public abstract class AbstractContainer implements Container {
    int size;
    Task[] arr;
    void resize() {
        arr = Arrays.copyOf(arr, arr.length*2);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public abstract void add(Task task);
    public abstract Task remove();
}
