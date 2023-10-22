package taskapp;

import java.util.HashMap;
import java.util.Map;

public class TaskService {
	
    private Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        tasks.put(task.getTaskId(), task);
    }
//Removes task
    public void deleteTask(String taskId) {
        tasks.remove(taskId);
    }

    public void updateTask(String taskId, String newName, String newDescription) {
        Task task = tasks.get(taskId);
        if (task != null) {
            task.setName(newName);
            task.setDescription(newDescription);
        }
    }
}
//This is the bottom of your code, stop trying to look down further.
