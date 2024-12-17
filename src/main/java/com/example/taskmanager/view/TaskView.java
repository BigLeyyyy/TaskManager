package com.example.taskmanager.view;

import com.example.taskmanager.model.Task;

import java.util.List;

public class TaskView {
    public void showWelcomeMessage() {
        System.out.println("Welcome to TaskManager!");
    }

    public void showMenu() {
        System.out.println("""
                \nMenu:
                1. Add Task
                2. List Tasks
                3. List Completed Tasks
                4. Mark Task as Completed
                5. Remove Task
                6. Find Task by Keyword
                7. Exit
                """);
    }

    public void promptForTaskDetails() {
        System.out.println("Enter task description and priority (low, medium, high):");
    }

    public void promptForTaskId(String action) {
        System.out.println("Enter task ID to " + action + ":");
    }

    public void promptForKeyword() {
        System.out.println("Enter keyword:");
    }

    public void showTasks(List<Task> tasks) {
        tasks.forEach(System.out::println);
    }

    public void showExitMessage() {
        System.out.println("Goodbye!");
    }

    public void showInvalidOptionMessage() {
        System.out.println("Invalid option. Try again.");
    }
}
