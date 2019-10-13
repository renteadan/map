package com.company;

public class TaskContainerFactory implements Factory {

    private static final TaskContainerFactory instance = new TaskContainerFactory();
    private TaskContainerFactory(){};

    static TaskContainerFactory getInstance() {
        return instance;
    }

    @Override
    public Container createContainer(String strategy) {
        if(strategy.equals("LIFO"))
            return new StackContainer();
        return new QueueContainer();
    }
}
