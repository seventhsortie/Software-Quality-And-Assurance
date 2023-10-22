package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import taskapp.Task;
import taskapp.TaskService;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Task1", "Description1");
        service.addTask(task);
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("2", "Task2", "Description2");
        service.addTask(task);
        service.deleteTask("2");
    }

    @Test
    public void testUpdateTask() {
        TaskService service = new TaskService();
        Task task = new Task("3", "Task3", "Description3");
        service.addTask(task);
        service.updateTask("3", "NewTask3", "NewDescription3");
    }
}
//End of your code. Don't look further down.'