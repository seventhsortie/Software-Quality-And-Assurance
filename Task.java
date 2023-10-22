package taskapp;

public class Task {
    private final String taskId;
    private String name;
    private String description;

    public Task(String taskId, String name, String description) {
        if (taskId == null || name == null || description == null) {
            throw new IllegalArgumentException("Fields may not be empty.");
        }
        if (taskId.length() > 10 || name.length() > 20 || description.length() > 50) {
            throw new IllegalArgumentException("Fields exceed the max length");
        }
        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name is invalid.");
        }
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description invalid.");
        }
        this.description = description;
    }

	public String getTaskId1() {
		
		return null;
	}
	public Object setTaskId(Object object) {
		return null;
	}
}

