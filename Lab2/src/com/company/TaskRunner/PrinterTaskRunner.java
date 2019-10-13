package com.company.TaskRunner;

import java.time.LocalDateTime;

public class PrinterTaskRunner extends AbstractTaskRunner {
    public PrinterTaskRunner(TaskRunner t) {
        super(t);
    }

    @Override
    public void executeOneTask() {
        System.out.println("Local time is : " + LocalDateTime.now());
        super.executeOneTask();
    }
}
