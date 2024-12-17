package com.example.taskmanager;

import com.example.taskmanager.controller.TaskController;

public class TaskManagerApplication {
    public static void main(String[] args) {
        TaskController taskController = new TaskController();
        taskController.start();
    }
}
