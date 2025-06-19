class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
        this.next = null;
    }
}

public class TaskManager{
    Task head = null;

    public void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) head = newTask;
        else {
            Task temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newTask;
        }
    }

    public void searchTask(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                System.out.println("Found: " + temp.taskName + " - " + temp.status);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.");
    }

    public void deleteTask(int id) {
        if (head == null) return;
        if (head.taskId == id) {
            head = head.next;
            return;
        }

        Task temp = head;
        while (temp.next != null && temp.next.taskId != id) temp = temp.next;

        if (temp.next != null) temp.next = temp.next.next;
    }

    public void displayTasks() {
        Task temp = head;
        while (temp != null) {
            System.out.println(temp.taskId + ": " + temp.taskName + " [" + temp.status + "]");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        tm.addTask(1, "Design UI", "Pending");
        tm.addTask(2, "Develop API", "In Progress");
        tm.addTask(3, "Test app", "Pending");

        tm.displayTasks();
        tm.searchTask(2);
        tm.deleteTask(1);

        System.out.println("\nAfter Deletion:");
        tm.displayTasks();
    }
}

