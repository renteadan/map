package com.company.TaskRunner;

import com.company.Container.Container;
import com.company.Container.TaskContainerFactory;
import com.company.Task.Task;

public class StrategyTaskRunner implements TaskRunner {
    private Container c;
    public StrategyTaskRunner(String strategy) {
        c = TaskContainerFactory.getInstance().createContainer(strategy);
    }
    public StrategyTaskRunner(String strategy, Task[] tasks) {
        c = TaskContainerFactory.getInstance().createContainer(strategy);
        for (Task x : tasks) {
            c.add(x);
        }
    }
    @Override
    public void executeOneTask() {
        Task t = c.remove();
        t.execute();
    }

    @Override
    public void executeAll() {
        while(!c.isEmpty())
            c.remove().execute();
    }

    @Override
    public void addTask(Task t) {
        c.add(t);
    }

    @Override
    public boolean hasTask() {
        return !c.isEmpty();
    }
}
