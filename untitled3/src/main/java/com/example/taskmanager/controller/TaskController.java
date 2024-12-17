package com.example.taskmanager.controller;

import com.example.taskmanager.service.TaskService;
import com.example.taskmanager.view.TaskView;

import java.util.Scanner;

public class TaskController {
    private final TaskService taskService;
    private final TaskView taskView;

    public TaskController() {
        this.taskService = new TaskService();
        this.taskView = new TaskView();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        taskView.showWelcomeMessage();

        while (true) {
            taskView.showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choice) {
                case 1 -> {
                    taskView.promptForTaskDetails();
                    String description = scanner.nextLine();
                    String priority = scanner.nextLine();
                    taskService.addTask(description, priority);
                }
                case 2 -> taskView.showTasks(taskService.listTasks());
                case 3 -> taskView.showTasks(taskService.listCompletedTasks());
                case 4 -> {
                    taskView.promptForTaskId("mark as completed");
                    int taskId = scanner.nextInt();
                    taskService.completeTask(taskId);
                }
                case 5 -> {
                    taskView.promptForTaskId("remove");
                    int taskId = scanner.nextInt();
                    taskService.removeTask(taskId);
                }
                case 6 -> {
                    taskView.promptForKeyword();
                    String keyword = scanner.nextLine();
                    taskView.showTasks(taskService.findTasksByKeyword(keyword));
                }
                case 7 -> {
                    taskView.showExitMessage();
                    return;
                }
                default -> taskView.showInvalidOptionMessage();
            }
        }
    }
}
