package com.example.taskmanager;

import com.example.taskmanager.model.Task;
import com.example.taskmanager.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void testAddTask() {
        taskService.addTask("Test Task", "high");
        List<Task> tasks = taskService.listTasks();

        assertEquals(1, tasks.size());
        Task task = tasks.get(0);
        assertEquals("Test Task", task.getDescription());
        assertEquals("high", task.getPriority());
    }
}
