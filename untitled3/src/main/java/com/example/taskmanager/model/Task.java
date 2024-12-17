package com.example.taskmanager.model;

public class Task {
    private static int counter = 0;

    private final int id;
    private final String description;
    private final String priority;
    private boolean completed;

    public Task(String description, String priority) {
        this.id = ++counter;
        this.description = description;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void complete() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", completed=" + completed +
                '}';
    }
    public String getPriority() {
        return priority;
    }
}
