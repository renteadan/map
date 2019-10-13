package com.company;

import java.util.Arrays;

class SortingTask extends Task {
    private int[] arr;

    public int[] getArr() {
        return arr;
    }
    SortingTask(String taskId, String description, int[] arr) {
        super(taskId, description);
        this.arr = arr;
    }

    void execute() {
        sort("quick");
        System.out.println(Arrays.toString(arr));
    }

    void execute(String strategy) {
        sort(strategy);
        System.out.println(Arrays.toString(arr));
    }

    private void sort(String strategy) {
        AbstractSorter sorter = new AbstractSorter();
        arr = sorter.sort(arr ,strategy);
    }
}
