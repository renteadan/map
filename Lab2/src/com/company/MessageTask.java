package com.company;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class MessageTask extends Task {
    private String message, to, from;
    private LocalDateTime date;

    MessageTask(String taskId, String description, String message, String from, String to) {
        super(taskId, description);
        this.message = message;
        this.from = from;
        this.to = to;
        date = LocalDateTime.now();
    }

    private String formatDate(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd hh:mm");
        return date.format(formatter);
    }

    void execute() {
        System.out.println(String.format("The message is %s and the date is %s",message, formatDate(date)));
    }

    void print() {
        System.out.println(String.format("id=%s|description=%s|message=%s|from=%s|to=%s|date=%s",getTaskId(), getDescription(), message, from, to, formatDate(date)));
    }
}
