package com.company.TaskRunner;

import com.company.Task.Task;

public class AbstractTaskRunner implements TaskRunner {

    private TaskRunner runner;

    AbstractTaskRunner(TaskRunner t) {
        runner = t;
    }

    @Override
    public void executeOneTask() {
        runner.executeOneTask();
    }

    @Override
    public void executeAll() {
        runner.executeAll();
    }

    @Override
    public void addTask(Task t) {
        runner.addTask(t);
    }

    @Override
    public boolean hasTask() {
        return runner.hasTask();
    }
}
