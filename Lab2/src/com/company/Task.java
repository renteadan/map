package com.company;

import java.util.Objects;

abstract class Task {
    private String taskId, description;

    Task(String taskId, String description) {
        this.taskId = taskId;
        this.description = description;
    }

    String getTaskId() {
        return taskId;
    }

    String getDescription() {
        return description;
    }

    abstract void execute();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task that = (Task) o;
        return taskId.equals(that.taskId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }
}
