// Student.java
public class Student {
    private String name;
    private String id;
    private int age;
    private String grade;

    public Student(String name, String id, int age, String grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    // Getters and Setters
    public String getName() { return name; }
    public String getId() { return id; }
    public int getAge() { return age; }
    public String getGrade() { return grade; }

    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("ID: %-5s | Name: %-15s | Age: %-3d | Grade: %s", id, name, age, grade);
    }

    // Method to convert student data to a single line for file storage
    public String toFileFormat() {
        return id + "," + name + "," + age + "," + grade;
    }
}