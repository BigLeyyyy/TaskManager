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

    @Test
    void testListTasksEmpty() {
        List<Task> tasks = taskService.listTasks();
        assertTrue(tasks.isEmpty(), "Task list should be empty initially.");
    }

    @Test
    void testListTasksSortedByPriority() {
        taskService.addTask("Task 1", "medium");
        taskService.addTask("Task 2", "low");
        taskService.addTask("Task 3", "high");

        List<Task> tasks = taskService.listTasks();

        assertEquals("Task 3", tasks.get(0).getDescription());
        assertEquals("Task 2", tasks.get(1).getDescription());
        assertEquals("Task 1", tasks.get(2).getDescription());
    }

    @Test
    void testCompleteTask() {
        taskService.addTask("Complete this", "high");
        Task task = taskService.listTasks().get(0);

        taskService.completeTask(task.getId());
        assertTrue(task.isCompleted(), "Task should be marked as completed.");
    }

    @Test
    void testCompleteTaskInvalidId() {
        taskService.addTask("Another task", "low");
        taskService.completeTask(999); // Invalid ID
        List<Task> tasks = taskService.listTasks();

        assertFalse(tasks.get(0).isCompleted(), "Task should not be completed for invalid ID.");
    }

    @Test
    void testRemoveTask() {
        taskService.addTask("Remove me", "medium");
        Task task = taskService.listTasks().get(0);

        taskService.removeTask(task.getId());
        List<Task> tasks = taskService.listTasks();

        assertTrue(tasks.isEmpty(), "Task list should be empty after removing the task.");
    }

    @Test
    void testRemoveTaskInvalidId() {
        taskService.addTask("Don't remove me", "high");

        taskService.removeTask(999); // Invalid ID
        List<Task> tasks = taskService.listTasks();

        assertEquals(1, tasks.size(), "Task list size should remain unchanged.");
    }

    @Test
    void testFindTasksByKeyword() {
        taskService.addTask("Buy groceries", "medium");
        taskService.addTask("Clean the house", "low");
        taskService.addTask("Finish homework", "high");

        List<Task> foundTasks = taskService.findTasksByKeyword("house");

        assertEquals(1, foundTasks.size());
        assertEquals("Clean the house", foundTasks.get(0).getDescription());
    }

    @Test
    void testFindTasksByKeywordNotFound() {
        taskService.addTask("Go running", "low");
        taskService.addTask("Read a book", "medium");

        List<Task> foundTasks = taskService.findTasksByKeyword("gym");

        assertTrue(foundTasks.isEmpty(), "No tasks should match the keyword 'gym'.");
    }
}
