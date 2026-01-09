// StudentManager.java
import java.util.*;
import java.io.*;

public class StudentManager {
    private List<Student> students;
    private final String FILE_NAME = "students.txt";

    public StudentManager() {
        this.students = new ArrayList<>();
        loadFromFile(); // Load existing data automatically
    }

    public void addStudent(Student stud) {
        students.add(stud);
        saveToFile(); // Persist data after changes
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
        } else {
            System.out.println("\n--- Registered Students ---");
            students.forEach(System.out::println);
        }
    }

    public boolean updateStudent(String id, String newName, int newAge, String newGrade) {
        for (Student st : students) {
            if (st.getId().equals(id)) {
                st.setName(newName);
                st.setAge(newAge);
                st.setGrade(newGrade);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(String id) {
        boolean removed = students.removeIf(st -> st.getId().equals(id));
        if (removed) saveToFile();
        return removed;
    }

    // NEW: Save students to a file
    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Student s : students) {
                writer.println(s.toFileFormat());
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    // NEW: Load students from a file
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Scanner reader = new Scanner(file)) {
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(",");
                if (data.length == 4) {
                    students.add(new Student(data[1], data[0], Integer.parseInt(data[2]), data[3]));
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}