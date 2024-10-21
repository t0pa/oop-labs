package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;
import java.util.stream.Collectors;

public class DataStructures {
    private List<TaskItem> tasks;

    public DataStructures() {
        tasks = Arrays.asList(
                new TaskItem(1, "Push lab code to the GitHub", Status.TO_DO),
                new TaskItem(2, "Prepare for the quiz", Status.IN_PROGRESS),
                new TaskItem(3, "Go over tasks from lab 2", Status.COMPLETED),
                new TaskItem(4, "Night out", Status.CANCELLED)
        );
    }

    // Method to get all tasks
    public List<TaskItem> getAllTasks() {
        return tasks;
    }

    // Method to get tasks by status
    public List<TaskItem> getByStatus(Status status) {
        return tasks.stream()
                .filter(task -> task.getTaskStatus() == status)
                .collect(Collectors.toList());
    }

    // Method to find tasks with id >= 2
    public List<TaskItem> getTasksWithIdGreaterThanOrEqualToTwo() {
        return tasks.stream()
                .filter(task -> task.getTaskId() >= 2)
                .collect(Collectors.toList());
    }

    // Method to print task descriptions using forEach stream method
    public void printTaskDescriptions() {
        tasks.forEach(task -> System.out.println(task.getTaskDescription()));
    }
}
