package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbConnect {
    private static final String CONNECTION_STRING = "jdbc:mysql://localhost:3306/lab3"; // Change to your database name
    private static final String USERNAME = "root"; // Change to your MySQL username
    private static final String PASSWORD = "root"; // Change to your MySQL password

    private Connection connection = null;

    public DbConnect() {
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Fetch all tasks
    public List<TaskItem> fetchAllTasks() {
        List<TaskItem> tasks = new ArrayList<>();
        String query = "SELECT id, task_description, task_status FROM tasks";

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String description = resultSet.getString("task_description");
                String statusString = resultSet.getString("task_status");
                Status status = Status.valueOf(statusString); // Convert string to Status enum
                tasks.add(new TaskItem(id, description, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tasks;
    }

    // Fetch task by ID
    public TaskItem fetchTaskById(int id) {
        TaskItem task = null;
        String query = "SELECT id, task_description, task_status FROM tasks WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String description = resultSet.getString("task_description");
                String statusString = resultSet.getString("task_status");
                Status status = Status.valueOf(statusString);
                task = new TaskItem(id, description, status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return task;
    }

    // Create a new task
    public void createTask(TaskItem task) {
        String query = "INSERT INTO tasks (id, task_description, task_status) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, task.getTaskId());
            statement.setString(2, task.getTaskDescription());
            statement.setString(3, task.getTaskStatus().name()); // Convert enum to string
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update task name
    public void updateTaskName(int id, String newName) {
        String query = "UPDATE tasks SET task_description = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, newName);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close the connection when done
    public void close() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
