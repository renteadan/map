package com.company.Task;

import java.util.Arrays;

class AbstractSorter {
    int[] sort(int[] arr, String strategy) {
        if ("bubble".equals(strategy)) {
            return bubbleSort(arr);
        }
        return quickSort(arr);
    }

    private void swap(int[] arr, int i, int j) {
        if( i < arr.length && j < arr.length) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private int [] bubbleSort(int[] arr) {
        boolean flag=true;
        while(flag) {
            flag = false;
            for(int i=0;i<arr.length-1;i++) {
                if(arr[i] > arr [i+1]) {
                    flag = true;
                    swap(arr ,i ,i+1);
                }
            }
        }
        return arr;
    }

    private int[] quickSort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}
