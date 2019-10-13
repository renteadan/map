package com.company.Test;

import com.company.Task.MessageTask;
import com.company.TaskRunner.DelayTaskRunner;
import com.company.TaskRunner.PrinterTaskRunner;
import com.company.TaskRunner.StrategyTaskRunner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
class TaskRunnerTest {

    @Test
    void runnerTest() {
        MessageTask[] arr = new MessageTask[]{
                new MessageTask("1", "t1", "m1", "Dan1", "Cineva1"),
                new MessageTask("2", "t2", "m2", "Dan2", "Cineva2"),
                new MessageTask("3", "t3", "m3", "Dan3", "Cineva3"),
                new MessageTask("4", "t4", "m4", "Dan4", "Cineva4"),
                new MessageTask("5", "t5", "m5", "Dan5", "Cineva5")
        };
        StrategyTaskRunner runner = new StrategyTaskRunner("FIFO");
        assertFalse(runner.hasTask());
        System.out.println("=====QUEUE=====");
        runner = new StrategyTaskRunner("FIFO", arr);
        runner.executeAll();
        System.out.println("=====STACK=====");
        runner = new StrategyTaskRunner("LIFO", arr);
        runner.executeAll();
        PrinterTaskRunner printer = new PrinterTaskRunner(runner);
        printer.addTask(new MessageTask("6", "printer", "test date printer", "Dan6", "Cineva6"));
        System.out.println("=====PRINTER=====");
        printer.executeOneTask();
        printer.executeAll();
        assertFalse(printer.hasTask());
        DelayTaskRunner sleeper = new DelayTaskRunner(runner);
        sleeper.addTask(new MessageTask("7", "sleeper", "test delay sleeper", "Dan7", "Cineva7"));
        System.out.println("=====SLEEPER=====");
        sleeper.executeOneTask();
        assertFalse(sleeper.hasTask());
    }
}
