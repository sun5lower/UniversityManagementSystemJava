import controller.CourseController;
import entity.Course;
import entity.Student;
import controller.StudentController;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    StudentController studentController = new StudentController();
CourseController courseController = new CourseController();
    public void showHomeScreen() {
        String choice = "";
        do {
            System.out.println("Welcome to the University\n"
                    + "\n1. Add Student \t\t\t\t\t\t\t\t5. Add Courses"
                    + "\n2. Enroll student in to the course\t\t\t6. View All Courses"
                    + "\n3. View Individual Student \t\t\t\t\t7. View Exam List"
                    + "\n4. View All Students \t\t \t\t\t\t8. View Single Exam Results\n"
                    + "\n9. Exit University"
            );
            System.out.print("\nChoose one of the options please: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    collectStudentInfoAndAddStudent();
                    break;
                case "2":
                    studentEnrollment();
                    break;
                case "3":
                    showSingleStudentsInfo();
                    break;
                case "4":
                    showAllStudentsInfo();
                    break;
                case "5":
                    addCourse();
                    break;
                case "6":
                    viewAllCourses();
                    break;
                case "7":
                    viewExamsList();
                    break;
                case "8":
                   viewSingleExamResults();
                    break;
                case "9":
                    System.out.println("Have a great day!");
                    return;
                default:
                    break;
            }
            System.out.print("\n Enter C to continue\n");
            scanner.nextLine();
        } while (!choice.equals("9"));

        return;
    }

    private void collectStudentInfoAndAddStudent() {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        StudentController studentController = new StudentController();

        Student newStudent = new Student();
        System.out.println("Add a new Student");

        System.out.println("Enter name:");
        newStudent.name = scanner.nextLine();

        System.out.println("Enter surname:");
        newStudent.surname = scanner.nextLine();

        System.out.println("Enter gradeYear:");
        newStudent.gradeYear = Integer.parseInt(scanner.nextLine());

        System.out.println(studentController.collectStudentInfoAndAddStudent(newStudent));

    }

    private void studentEnrollment() {
        System.out.println("Type your name please:");
        String name = scanner.nextLine();
        System.out.println("Type your surname:");
        String surname = scanner.nextLine();
        System.out.println("Enroll in:\n 1. ....\n2. ....\n3. ....\n4. ....\n5......");

        String course = scanner.nextLine();
        System.out.println(name + surname + "You are enrolled into " + course);
    }

    private void showSingleStudentsInfo() {
        System.out.println("Enter ID of student to find:");
        Student student = studentController.findStudentByID(scanner.nextInt());
        System.out.println(student.name + " " + student.surname + " - " + "Year" + student.gradeYear + ". " + "Enrolled in " + student.courseEnrolled);
    }

    private void showAllStudentsInfo() {
        ArrayList<Student> students = new ArrayList<>();
        students = studentController.getAll();
        System.out.println("All students in the University:\n");
        for (Student currentStudent : students) {
            System.out.println("ID " + currentStudent.id + " - " + currentStudent.name + " " + currentStudent.surname + ". " + "Grade Year - " + currentStudent.gradeYear + "Enrolled into: " + currentStudent.courseEnrolled);
        }
    }
    private void addCourse() {
        Course course = new Course();
        Scanner scanner = new Scanner(System.in);
        CourseController courseController = new CourseController();

        Course newCourse = new Course();
        System.out.println("Add a new Course");

        System.out.println("Enter name:");
        newCourse.name = scanner.nextLine();

        System.out.println("Enter number of participants");
        newCourse.number_attending = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter time when the course Starts:");
        newCourse.start_at = Time.valueOf(scanner.nextLine());

        System.out.println("Enter time when the course Ends:");
        newCourse.start_at = Time.valueOf(scanner.nextLine());

        System.out.println(courseController.addCourse(newCourse));

    }
    private void viewAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        courses = courseController.getAll();

        System.out.println("Course schedule:\n");
        for (Course currentCourse : courses) {
            System.out.println("ID " + currentCourse.id + " - " + currentCourse.name +
                    " | " + currentCourse.start_at +
                    " | " + currentCourse.end_at +
                    " | " + currentCourse.number_attending);
        }
    }

    private void   viewExamsList(){}
    private void   viewSingleExamResults(){}
}




