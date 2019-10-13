package com.company.Test;

import com.company.Task.MessageTask;
import com.company.Task.SortingTask;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortingTaskTest {

    @Test
    void sortTest() {
        int[] arr = new int[]{1,5, -1 ,3};
        int[] expected = new int[]{-1 ,1 ,3 ,5};
        SortingTask sorter = new SortingTask("1", "sorter", arr);
        sorter.execute("quick");
        arr = sorter.getArr();
        assertArrayEquals(arr ,expected);
        arr = new int[]{1,5, -1 ,3};
        sorter = new SortingTask("1", "bubble sort", arr);
        sorter.execute("bubble");
        arr = sorter.getArr();
        assertArrayEquals(arr ,expected);
        sorter.execute();
    }

    @Test
    void printTasks() {
        MessageTask[] arr = new MessageTask[]{
                new MessageTask("1", "t1", "m1", "Dan1", "Cineva1"),
                new MessageTask("2", "t2", "m2", "Dan2", "Cineva2"),
                new MessageTask("3", "t3", "m3", "Dan3", "Cineva3"),
                new MessageTask("4", "t4", "m4", "Dan4", "Cineva4"),
                new MessageTask("5", "t5", "m5", "Dan5", "Cineva5")
        };
        for(MessageTask x : arr){
            x.print();
        }
        arr[0].execute();
        MessageTask m = new MessageTask("1","ceva", "equals", "t1","t2");
        assertEquals(arr[0], m);
        assertEquals(arr[0].hashCode(), m.hashCode());
    }
}
