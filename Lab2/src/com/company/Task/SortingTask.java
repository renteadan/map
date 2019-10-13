package com.company.Task;

import java.util.Arrays;

public class SortingTask extends Task {
    private int[] arr;

    public int[] getArr() {
        return arr;
    }
    public SortingTask(String taskId, String description, int[] arr) {
        super(taskId, description);
        this.arr = arr;
    }

    public void execute() {
        sort("quick");
        System.out.println(Arrays.toString(arr));
    }

    public void execute(String strategy) {
        sort(strategy);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(String strategy) {
        AbstractSorter sorter = new AbstractSorter();
        arr = sorter.sort(arr ,strategy);
    }
}
