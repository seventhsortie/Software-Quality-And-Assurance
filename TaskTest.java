package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import taskapp.Task;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("1", "taskName", "taskDescription");
        assertEquals("1", task.getTaskId());
        assertEquals("taskName", task.getName());
        assertEquals("taskDescription", task.getDescription());
    }

    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "name", "description"));
    }

    @Test
    public void testInvalidTaskName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", null, "description"));
    }

    @Test
    public void testInvalidTaskDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "name", null));
    }

    @Test
    public void testTaskIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "name", "description"));
    }

    @Test
    public void testTaskNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "ThisNameIsWayTooLongForTheField", "description"));
    }

    @Test
    public void testTaskDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "name", "ThisDescriptionIsWayTooLongForTheFieldAndShouldThrowAnException"));
    }

    @Test
    public void testSetName() {
        Task task = new Task("1", "name", "description");
        task.setName("newName");
        assertEquals("newName", task.getName());
    }

    @Test
    public void testSetInvalidName() {
        Task task = new Task("1", "name", "description");
        assertThrows(IllegalArgumentException.class, () -> task.setName(null));
    }

    @Test
    public void testSetDescription() {
        Task task = new Task("1", "name", "description");
        task.setDescription("newDescription");
        assertEquals("newDescription", task.getDescription());
    }

    @Test
    public void testSetInvalidDescription() {
        Task task = new Task("1", "name", "description");
        assertThrows(IllegalArgumentException.class, () -> task.setDescription(null));
    }

    @Test
    public void testSetNameTooLong() {
        Task task = new Task("1", "name", "description");
        assertThrows(IllegalArgumentException.class, () -> task.setName("ThisNameIsWayTooLongForTheField"));
    }

    @Test
    public void testSetDescriptionTooLong() {
        Task task = new Task("1", "name", "description");
        assertThrows(IllegalArgumentException.class, () -> task.setDescription("ThisDescriptionIsWayTooLongForTheFieldAndShouldThrowAnException"));
    }

    @Test
    public void testTaskIdMaxLength() {
        Task task = new Task("1234567890", "name", "description");
        assertEquals("1234567890", task.getTaskId());
    }

    @Test
    public void testTaskNameMaxLength() {
        Task task = new Task("1", "ThisNameIsExactlyOk", "description");
        assertEquals("ThisNameIsExactlyOk", task.getName());
    }

    @Test
    public void testTaskDescriptionMaxLength() {
        Task task = new Task("1", "name", "ThisDescIsExactlyFiftyCharactersInLengthOk");
        assertEquals("ThisDescIsExactlyFiftyCharactersInLengthOk", task.getDescription());
    }

    @Test
    public void testGetTaskId1() {
        Task task = new Task("1", "name", "description");
        assertNull(task.getTaskId1());
    }

    @Test
    public void testSetTaskId() {
        Task task = new Task("1", "name", "description");
        assertNull(task.setTaskId(null));
    }

    @Test
    public void testEmptyTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task("", "name", "description"));
    }

    @Test
    public void testEmptyTaskName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "", "description"));
    }

    @Test
    public void testEmptyTaskDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("1", "name", ""));
    }

    @Test
    public void testTaskIdSpecialCharacters() {
        assertThrows(IllegalArgumentException.class, () -> new Task("!@#", "name", "description"));
    }

    @Test
    public void testTaskNameSpecialCharacters() {
        Task task = new Task("1", "!@#", "description");
        assertEquals("!@#", task.getName());
    }

    @Test
    public void testTaskDescriptionSpecialCharacters() {
        Task task = new Task("1", "name", "!@#");
        assertEquals("!@#", task.getDescription());
    }

    @Test
    public void testTaskIdMinLength() {
        Task task = new Task("1", "name", "description");
        assertEquals("1", task.getTaskId());
    }

    @Test
    public void testTaskNameMinLength() {
        Task task = new Task("1", "a", "description");
        assertEquals("a", task.getName());
    }

    @Test
    public void testTaskDescriptionMinLength() {
        Task task = new Task("1", "name", "a");
        assertEquals("a", task.getDescription());
    }
}
