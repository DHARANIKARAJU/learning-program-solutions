class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() { return name; }
    public String getId() { return id; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("Student: " + student.getName() + ", ID: " + student.getId() + ", Grade: " + student.getGrade());
    }
}

class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void setGrade(String grade) {
        model.setGrade(grade);
    }

    public void updateView() {
        view.displayStudentDetails(model);
    }
}

class MVCTest {
    public static void main(String[] args) {
        Student student = new Student("Alice", "001", "A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(student, view);

        controller.updateView();
        controller.setGrade("A+");
        controller.updateView();
    }
}
