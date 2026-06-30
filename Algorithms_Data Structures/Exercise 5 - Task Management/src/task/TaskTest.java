package task;

public class TaskTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Task Management System ===");

        TaskLinkedList list = new TaskLinkedList();

        Task t1 = new Task("T001", "Design Database", "In Progress");
        Task t2 = new Task("T002", "Implement API", "Pending");
        Task t3 = new Task("T003", "Write Unit Tests", "Pending");

        list.addTask(t1);
        list.addTask(t2);
        list.addTask(t3);

        System.out.println("All Tasks:");
        list.traverseTasks();

        System.out.println("\nSearching for Task T002...");
        Task found = list.searchTask("T002");
        System.out.println("Search Result: " + found);

        System.out.println("\nDeleting Task T001...");
        list.deleteTask("T001");

        System.out.println("\nTasks After Deletion:");
        list.traverseTasks();
    }
}
