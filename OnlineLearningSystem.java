import java.util.ArrayList;
import java.util.List;

abstract class User {
    private String id;
    private String name;
    private String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public abstract void displayRole();
}

class Student extends User {

    public Student(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void displayRole() {
        System.out.println("[Role: Student] ID: " + getId() + " - Name: " + getName());
    }

    public Submission submitAssignment(Assignment assignment, String file) {
        System.out.println(getName() + " submitted assignment: " + assignment.getTitle());
        return new Submission(this, assignment, file);
    }

    public void viewGrades() {
        System.out.println(getName() + " is viewing grades.");
    }
}

class Instructor extends User {

    public Instructor(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public void displayRole() {
        System.out.println("[Role: Instructor] ID: " + getId() + " - Name: " + getName());
    }

    public void gradeAssignment(Submission submission, double score, String feedback) {
        submission.setScore(score);
        submission.setFeedback(feedback);
        System.out.println("Instructor " + getName() + " graded assignment.");
    }
}

class Assignment {

    private String assignmentId;
    private String title;
    private double maxScore;
    private String deadline;

    public Assignment(String id, String title, double maxScore, String deadline) {
        this.assignmentId = id;
        this.title = title;
        this.maxScore = maxScore;
        this.deadline = deadline;
    }

    public String getAssignmentId() { return assignmentId; }
    public String getTitle() { return title; }
    public double getMaxScore() { return maxScore; }
    public String getDeadline() { return deadline; }
}

class Submission {

    private Student student;
    private Assignment assignment;
    private String submittedFile;
    private double score;
    private String feedback;

    public Submission(Student student, Assignment assignment, String file) {
        this.student = student;
        this.assignment = assignment;
        this.submittedFile = file;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void showResult() {
        System.out.println("Student: " + student.getName());
        System.out.println("Assignment: " + assignment.getTitle());
        System.out.println("Score: " + score);
        System.out.println("Feedback: " + feedback);
    }
}

class Course {

    private String courseId;
    private String courseName;
    private Instructor instructor;
    private List<Student> listOfStudents = new ArrayList<>();
    private List<Assignment> assignments = new ArrayList<>();
    private List<Submission> submissions = new ArrayList<>();

    public Course(String id, String name, Instructor instructor) {
        this.courseId = id;
        this.courseName = name;
        this.instructor = instructor;
    }

    public void enrollStudent(Student student) {
        listOfStudents.add(student);
        System.out.println("Success: " + student.getName() + " enrolled in " + courseName);
    }

    public void addAssignment(Assignment a) {
        assignments.add(a);
        System.out.println("Assignment added: " + a.getTitle());
    }

    public void addSubmission(Submission s) {
        submissions.add(s);
    }

    public void showCourseInfo() {
        System.out.println("\n--- COURSE DASHBOARD ---");
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructor.getName());
        System.out.println("Total Students: " + listOfStudents.size());
        System.out.println("Total Assignments: " + assignments.size());
        System.out.println("------------------------\n");
    }
}

public class OnlineLearningSystem {

    public static void main(String[] args) {

        User u1 = new Student("24520652", "Cao Minh Huy", "24520652@gm.uit.edu.vn");
        User u2 = new Instructor("1111", "Huynh Ngoc Tin", "tinhn@uit.edu.vn");

        u1.displayRole();
        u2.displayRole();

        
        Student student = (Student) u1;
        Instructor instructor = (Instructor) u2;

        Course oopCourse = new Course("IT002", "Object Oriented Programming", instructor);

        oopCourse.enrollStudent(student);

        Assignment bt1 = new Assignment("BTLT1", "Bai Tap OOP Java", 10.0, "2026-03-14");

        oopCourse.addAssignment(bt1);

        oopCourse.showCourseInfo();

        
        Submission sub = student.submitAssignment(bt1, "bt1.pdf");

        oopCourse.addSubmission(sub);

        
        instructor.gradeAssignment(sub, 9.5, "Good work!");

        
        sub.showResult();
    }
}