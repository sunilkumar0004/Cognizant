package employee;

public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("=== Testing Employee Management System ===");

        EmployeeManagement manager = new EmployeeManagement(5);

        Employee emp1 = new Employee("E001", "John Miller", "Software Engineer", 85000);
        Employee emp2 = new Employee("E002", "Sarah Connor", "Project Manager", 95000);
        Employee emp3 = new Employee("E003", "Kyle Reese", "Security Analyst", 75000);

        manager.addEmployee(emp1);
        manager.addEmployee(emp2);
        manager.addEmployee(emp3);

        System.out.println("Current Employees:");
        manager.traverseEmployees();

        System.out.println("\nSearching for Employee E002...");
        Employee found = manager.searchEmployee("E002");
        System.out.println("Search Result: " + found);

        System.out.println("\nDeleting Employee E001...");
        manager.deleteEmployee("E001");

        System.out.println("\nEmployees After Deletion:");
        manager.traverseEmployees();
    }
}
