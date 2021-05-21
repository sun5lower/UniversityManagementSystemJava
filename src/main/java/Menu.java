import controller.CourseController;
import controller.ExamController;
import entity.Course;
import entity.CourseEnrollment;
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
    CourseEnrollment courseEnrollment = new CourseEnrollment();


    public void showHomeScreen() {

        String choice = "";
        do {
            System.out.println("\nWelcome to the University\n"
                    + "\n1. Add Student \t\t\t\t\t\t\t\t7. Add Course\t\t\t\t\t\t11. Create Exam List"
                    + "\n2. View All Students\t\t\t\t\t\t8. View All Courses\t\t\t\t\t12. View Exam List "
                    + "\n3. View Single Student info \t\t\t\t9. View Single Course info\t\t\t13. View Single Exam results"
                    + "\n4. Enroll student in to the course \t\t\t10. Find Exam By Course Name"
                    + "\n5. View Student Exams"
                    + "\n6. Delete student\n"


                    + "\n14. Exit University"
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
                case "7":
                    addCourse();
                    break;
                case "8":
                    viewAllCourses();
                    break;
                case "12":
                    viewExamList();
                    break;
                case "9":
                    viewSingleCourseInfo();
                    break;
                case "11":
                    createExamList();
                    break;
                case "13":
                    viewSingleExamResults();
                    break;
                case "6":
                    deleteStudent();
                    break;
                case "10":
                    findExamByCourseName();
                    break;
                case "5":
                    getStudentExams();
                    break;
                case "14":
                    System.out.println("Have a great day!");
                    return;
                default:
                    break;
            }


        } while (!choice.equals("14"));

        return;
    }

    private void AddStudent() {
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
        System.out.println("ID\t\t\t\t Student name and surname\n");
        for (Student currentStudent : students) {

            System.out.println(currentStudent.id + "\t\t\t\t  " + currentStudent.name + " " + currentStudent.surname);
        }
    }

    private void viewSingleStudentsInfo() {
        System.out.println("Enter ID of student to find:");
        Student student = studentController.findStudentByID(scanner.nextInt());
        System.out.println(student.name + " " + student.surname + " - " + "Year " + student.gradeYear);
        System.out.println("\n==== Registered Courses For Student =====\n");
        ArrayList<Course> enrolledCourses = courseController.findCoursesEnrolledByStudent(student.id);
        enrolledCourses.forEach(System.out::println);
    }

    private void enrollStudentToCourse() {
        System.out.println("Add new course enrollment");

        System.out.println("Enter student Id:");
        courseEnrollment.studentId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter course Id:");
        courseEnrollment.courseId = Integer.parseInt(scanner.nextLine());

        System.out.println(courseController.enrollStudent(courseEnrollment));

    }

    private void addCourse() {

        Course newCourse = new Course();
        System.out.println("Add a new Course");

        System.out.println("Enter name:");
        newCourse.name = scanner.nextLine();

        System.out.println(courseController.addCourse(newCourse));

    }

    private void viewAllCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        courses = courseController.getAll();

        System.out.println("Course list:\n");
        System.out.println("ID\t\tCourse name");
        for (Course currentCourse : courses) {
            System.out.println("ID " + currentCourse.id + " - " + currentCourse.name);
        }
    }


    private void viewSingleCourseInfo() {
        System.out.println("Enter ID of course to find:");
        Course course = courseController.findCourseByID(scanner.nextInt());
        System.out.println(course.name);
        System.out.println("\n==== Students enrolled into the Course =====\n");

        ArrayList<Student> enrolledCourses = studentController.findStudentEnrolledInCourse(course.id);
        enrolledCourses.forEach(System.out::println);
        }

    private void createExamList() {

        Exam newExam = new Exam();
        System.out.println("Create Exam");

        System.out.println("Enter course ID:");
        newExam.courseId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter Exam Date:");
        newExam.examDate = scanner.nextLine();

        System.out.println("Enter Student ID:");
        newExam.studentId = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter result");
        newExam.result = Integer.parseInt(scanner.nextLine());

        System.out.println(examController.createExamList(newExam));
    }

    private void viewExamList() {
        ArrayList<Exam> exams = new ArrayList<>();
        exams = examController.getAll();

        System.out.println("Exam list:\n");
        System.out.println("ID\t\t\t\t\t\t Exam name\t\t\t\t\t\t  Exam date");
        for (Exam currentExam : exams) {
            System.out.println(currentExam.courseName + " - " + currentExam.examDate);
        }
    }

    private void viewSingleExamResults() {
        System.out.println("Enter course name to find:");
        Exam exam = examController.findExamByCourseName(scanner.nextLine());
        System.out.println(exam.courseName + " " + exam.examDate + " - " + exam.studentName + ". " + exam.result);
    }

    private void deleteStudent() {

        Student deleteStudent = new Student();
        System.out.println("Delete a Student");

        System.out.println("Enter student ID:");
        deleteStudent.id = Integer.parseInt(scanner.nextLine());

        System.out.println(studentController.delete(deleteStudent));

    }



    private void getStudentExams(){

        ArrayList<Exam> enrolledCourses = examController.getStudentExams(courseEnrollment.studentId);
        enrolledCourses.forEach(System.out::println);

        enrolledCourses = examController.getStudentExams(courseEnrollment.studentId);

        System.out.println("Exam list:\n");
        System.out.println("Exam name\t\t\tExam date\t\t\t Result");
        for (Exam currentExam : enrolledCourses) {
            System.out.println(currentExam.courseName + " - " + currentExam.examDate+ " - " + currentExam.result);
        }


    }


    private void findExamByCourseName(){




    }

}






