package com.example.taskmanager.service;

import com.example.taskmanager.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(String description, String priority) {
        tasks.add(new Task(description, priority));
    }

    public List<Task> listTasks() {
        return new ArrayList<>(tasks);
    }

    public List<Task> listCompletedTasks() {
        return tasks.stream().filter(Task::isCompleted).collect(Collectors.toList());
    }

    public void completeTask(int id) {
        tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst()
                .ifPresent(Task::complete);
    }

    public void removeTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    public List<Task> findTasksByKeyword(String keyword) {
        return tasks.stream()
                .filter(task -> task.getDescription().contains(keyword))
                .collect(Collectors.toList());
    }
}
