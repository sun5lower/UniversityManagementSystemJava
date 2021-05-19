import controller.University;
import entity.Course;
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

    private boolean studentEnrollment() {
        System.out.println("Type your name please:");
        String name = scanner.nextLine();
        System.out.println("Type your surname:");
        String surname = scanner.nextLine();
        System.out.println("Type your gradeYear:");
        String gradeYear = scanner.nextLine();
        System.out.println();

        return false;
    }

   private void showSingleStudentsInfo() {
      System.out.println("Enter name of student to find:");
        ArrayList<Student> students = new ArrayList<>();
        studentController.findStudent(scanner.nextLine());
        System.out.println(studentEnrollment());
        for (Student currentStudent : students) {
            System.out.println(currentStudent.name + currentStudent.surname + " - " + currentStudent.gradeYear + "Grade Year.");

        }}

    private void showAllStudentsInfo() {
        ArrayList<Student> students = new ArrayList<>();
            students = studentController.getAll();

            for (Student currentStudent: students){
                System.out.println(currentStudent.name + currentStudent.surname + currentStudent.gradeYear + currentStudent.id);
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

   /* private void showAllStudents() {
        ArrayList<Student> students = ArrayList<Student>studentController.findStudent(scanner.nextLine());
        System.out.println(students.size() + " Student found");
        for (Student currentStudent: students){
            System.out.println(currentStudent.getName() + " - " + currentStudent.getSurname());
        }
        System.out.println("All students");
        students = studentController.getAll();

                for (Student currentStudent: students){
            System.out.println(Student.getName() +
                    " | " + currentStudent.getSurname() +
                    " | " + currentStudent.getGradeYear()); ;


    //needs adjusting to courses info-variables


*/
