package mvc;

public class MVCTest {
    public static void main(String[] args) {
        System.out.println("=== Testing MVC Pattern ===");

        Student studentModel = retrieveStudentFromDatabase();

        StudentView view = new StudentView();

        StudentController controller = new StudentController(studentModel, view);

        System.out.println("--- Initial State ---");
        controller.updateView();

        System.out.println("\nUpdating student grade to 'A+'...");
        controller.setStudentGrade("A+");

        System.out.println("--- Updated State ---");
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        return new Student("S101", "John Doe", "A");
    }
}
