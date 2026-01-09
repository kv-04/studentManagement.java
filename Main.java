// Main.java
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            try {
                System.out.println("\n=== Professional Student System ===");
                System.out.println("1. Add | 2. View | 3. Update | 4. Delete | 5. Exit");
                System.out.print("Choice: ");
                
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer

                if (choice == 5) break;

                switch (choice) {
                    case 1:
                        System.out.print("ID: "); String id = scanner.nextLine();
                        System.out.print("Name: "); String name = scanner.nextLine();
                        System.out.print("Age: "); int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Grade: "); String grade = scanner.nextLine();
                        manager.addStudent(new Student(name, id, age, grade));
                        break;
                    case 2:
                        manager.displayAllStudents();
                        break;
                    case 4:
                        System.out.print("ID to Delete: ");
                        String delId = scanner.nextLine();
                        System.out.println(manager.deleteStudent(delId) ? "Deleted." : "Not found.");
                        break;
                    default:
                        System.out.println("Invalid Option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only for age and choices.");
                scanner.nextLine(); // Clear the bad input
            }
        }
        System.out.println("System Closed.");
        scanner.close();
    }
}