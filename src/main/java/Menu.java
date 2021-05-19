import entity.Student;
import controller.StudentController;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    University university = new University();
    StudentController studentController = new StudentController();


    public void showHomeScreen() {
        String choice = "";
        do {
            System.out.println("Welcome to the University\n"
                    + "\n1. Add Student \t\t\t\t\t\t\t\t5. Add Courses"
                    + "\n2. Enroll student in to the course\t\t\t6. View All Courses"
                    + "\n3. View Individual Student \t\t\t\t\t7. View Exam Results"
                    + "\n4. View All Students \t\t \t\t\t\t8. View All Courses\n"
                    + "\n9. Exit University"
            );
            System.out.print("\nChoose one of the below options please: ");
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
                case "5":
                    showAllCourses();
                    break;
                case "6":
                    viewAllCourses();
                    break;
                case "7":
                    viewExamResults();
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
            System.out.println("All students in the University:\n" );
        for (Student currentStudent : students) {
         System.out.println("ID " + currentStudent.id + " - "+ currentStudent.name + " " + currentStudent.surname +". " +  "Grade Year - " + currentStudent.gradeYear + "Enrolled into: " + currentStudent.courseEnrolled);
        }
    }


    private void showAllCourses() {
         /*for (Student currentCourses : university.getCourses()) {
            System.out.println(Courses.getName() +
                    " | " + currentCourses.getSurname() +
                    " | " + currentCourses.getGradeYear()); */
    }


    private void viewExamResults() {
    }

    private void viewAllCourses() {
    }
}




