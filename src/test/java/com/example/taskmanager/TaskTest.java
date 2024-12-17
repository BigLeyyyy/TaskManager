package com.example.taskmanager.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testTaskCreation() {
        Task task = new Task("Write code", "high");

        assertEquals("Write code", task.getDescription());
        assertEquals("high", task.getPriority());
        assertFalse(task.isCompleted(), "New task should not be completed by default.");
    }

    @Test
    void testCompleteTask() {
        Task task = new Task("Finish the report", "medium");
        assertFalse(task.isCompleted(), "Task should initially be incomplete.");

        task.complete();
        assertTrue(task.isCompleted(), "Task should be marked as completed.");
    }

    @Test
    void testToStringOutput() {
        Task task = new Task("Test Task", "low");
        String expectedOutput = "Task{id=1, description='Test Task', priority='low', completed=false}";

        assertTrue(task.toString().contains("Test Task"));
        assertTrue(task.toString().contains("priority='low'"));
    }
}
