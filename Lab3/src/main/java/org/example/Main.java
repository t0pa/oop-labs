package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataStructures ds = new DataStructures();

        // Get all tasks
       // System.out.println("All tasks:");
        //ds.getAllTasks().forEach(System.out::println);

        // Get tasks by status
        //System.out.println("\nTasks with status IN_PROGRESS:");
       // ds.getByStatus(Status.IN_PROGRESS).forEach(System.out::println);

        // Get tasks with id >= 2
        //System.out.println("\nTasks with id >= 2:");
       // ds.getTasksWithIdGreaterThanOrEqualToTwo().forEach(System.out::println);

        // Print task descriptions
       // System.out.println("\nTask Descriptions:");
        //ds.printTaskDescriptions();



        DbConnect dbConnect = new DbConnect();

        // Fetch and print all tasks
        List<TaskItem> allTasks = dbConnect.fetchAllTasks();
        for (TaskItem task : allTasks) {
            System.out.println(task);
        }

        // Fetch a specific task by ID
        TaskItem taskById = dbConnect.fetchTaskById(1);
        System.out.println("Fetched Task: " + taskById);

        // Create a new task
        TaskItem newTask = new TaskItem(5, "New Task Example", Status.TO_DO);
        dbConnect.createTask(newTask);

        // Update a task name
        dbConnect.updateTaskName(1, "Updated Task Name");

        // Close the connection
        dbConnect.close();


    }
}


