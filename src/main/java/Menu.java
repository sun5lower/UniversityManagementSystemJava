import controller.CourseController;
import controller.ExamController;
import entity.Course;
import entity.Exam;
import entity.Student;
import controller.StudentController;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    StudentController studentController = new StudentController();
    CourseController courseController = new CourseController();
    ExamController examController = new ExamController();

    public void showHomeScreen() {
        String PIN = "";
        System.out.println("Please enter your PIN");
        while (!PIN.equals("8888")) {
            PIN = scanner.next().trim();
            if (PIN.equals("8888")) {
                break;
            } else {
                System.out.println("Incorrect, please try again.");
            }
        }
        System.out.println("PIN is correct!");

        String choice = "";
        do {
            System.out.println("Welcome to the University\n"
                    + "\n1. Add Student \t\t\t\t\t\t\t\t6. Add Course"
                    + "\n2. View All Students \t\t \t\t\t\t7. View All Courses"
                    + "\n3. View Single Student info \t\t\t\t8. View Single Course info"
                    + "\n4. Enroll student in to the course \t\t\t9. Exam"
                    + "\n5. View Exam List \t\t\t\t\t\t\t10. View Single Exam results"
                    + "\n11. Delete student\n"
                    + "\n12. Exit University"
            );

            System.out.print("\nChoose the number for activity You would like to perform: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    AddStudent();
                    break;
                case "2":
                    viewAllStudents();
                    break;
                case "3":
                    viewSingleStudentsInfo();
                    break;
                case "4":
                    enrollStudentToCourse();
                    break;
                case "6":
                    addCourse();
                    break;
                case "7":
                    viewAllCourses();
                    break;
                case "5":
                    viewExamList();
                    break;
                case "8":
                    viewSingleCourseInfo();
                    break;
                case "9":
                    createExamList();
                    break;
                case "10":
                    viewSingleExamResults();
                    break;
                case "11":
                    deleteStudent();
                    break;
                case "12":
                    System.out.println("Have a great day!");
                    return;
                default:
                    break;
            }
            System.out.print("\n Enter C to continue\n");
            scanner.nextLine();

        } while (!choice.equals("12"));

        return;
    }

    private void AddStudent() {
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

        System.out.println(studentController.addStudent(newStudent));

    }
    private void viewAllStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students = studentController.getAll();
        System.out.println("All students in the University:\n");
        System.out.println( "ID\t\t\t\t Student name and surname\n");
        for (Student currentStudent : students) {

            System.out.println( currentStudent.id + "\t\t\t\t  " + currentStudent.name + " " + currentStudent.surname );
        }
    }
    private void viewSingleStudentsInfo() {
        System.out.println("Enter ID of student to find:");
        Student student = studentController.findStudentByID(scanner.nextInt());
        System.out.println(student.name + " " + student.surname + " - " + "Year" + student.gradeYear + ". " + "Enrolled in " + student.courseEnrolled);
    }
    private void enrollStudentToCourse() {

            do {
                System.out.print("Enter your name ");
                String name = scanner.nextLine();

                System.out.print("Enter course you want to enroll( x to quit): ");
                Scanner scanner = new Scanner(System.in);
                String course = scanner.nextLine();
                if (!course.equals("x")) {
                    course = course + "\n " + course;

                } else {
                    break;
                }
            } while (1 != 0);

        }

    private void addCourse() {
        Course course = new Course();
        Scanner scanner = new Scanner(System.in);
        CourseController courseController = new CourseController();

        Course newCourse = new Course();
        System.out.println("Add a new Course");

        System.out.println("Enter name:");
        newCourse.name = scanner.nextLine();

        System.out.println("Enter time when the course Starts:");
        newCourse.start_at = scanner.nextLine();

        System.out.println("Enter time when the course Ends:");
        newCourse.start_at = scanner.nextLine();

        System.out.println("Enter number of participants");
        newCourse.number_attending = Integer.parseInt(scanner.nextLine());

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
    private void viewSingleCourseInfo(){}
    private void createExamList() {
        Exam exam = new Exam();
        Scanner scanner = new Scanner(System.in);
        ExamController examController = new ExamController();

        Exam newExam = new Exam();
        System.out.println("Add a new Course");

        System.out.println("Enter course name:");
        newExam.courseName = scanner.nextLine();

        System.out.println("Enter Exam Date:");
        newExam.examDate = scanner.nextLine();

        System.out.println("Enter Student Name:");
        newExam.studentName = scanner.nextLine();

        System.out.println("Enter result");
        newExam.result = Integer.parseInt(scanner.nextLine());

        System.out.println(examController.createExamList(newExam));

    }
    private void viewExamList(){}
    private void viewSingleExamResults() {
        System.out.println("Enter course name to find:");
        Exam exam = examController.findExamByCourseName(scanner.nextLine());
        System.out.println(exam.courseName + " " + exam.examDate + " - " +  exam.studentName + ". " + exam.result);
    }

    private void deleteStudent(){

        Scanner scanner = new Scanner(System.in);
        StudentController studentController = new StudentController();

        Student deleteStudent = new Student();
        System.out.println("Delete a Student");

        System.out.println("Enter name:");
        deleteStudent.id = Integer.parseInt(scanner.nextLine());

        System.out.println(studentController.delete(deleteStudent));

    }

    }






