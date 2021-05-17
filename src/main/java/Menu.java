import controller.University;
import entity.Courses;
import entity.Student;
import types.UserType;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    University university = new University();
    private Object StudentEmail;

    public void showHomeScreen(){
        String choice = "";
        System.out.println("Welcome to the University"
                + "\n1. Add Student \t\t 4. Add Courses"
                + "\n2. View All Students \t\t 5. View All Courses"
                + "\n3. View Individual Student \t\t 6. View Exam Results"
                + "\n7. Exit University"
        );

        System.out.print("Choose one of the below options please: ");
        choice = scanner.nextLine();

        switch (choice){
            case "1":
                studentEnrollment();
                break;
            case "2":
                showAllStudents();
                break;
            case "3":
                showOneStudent();
            case "4":
                showAllCourses();
                break;
            case "5":
                viewAllCourses();
                break;
            case "6":
                viewExamResults();
                break;
            case "7":
                return;
            default:
                break;
        }
        this.showHomeScreen();
    }

    private void viewExamResults() {
    }

    private void viewAllCourses() {
    }

    private void showAllStudents() {
        for (Student currentStudent: university.getStudents()){
            System.out.println(Student.getName() +
                    " | " + currentStudent.getSurname() +
                    " | " + currentStudent.getGradeYear()); ;
        }
    }
//needs adjusting to courses info-variables
    private void showAllCourses() {
        for (Student currentCourses : university.getCourses()) {
            System.out.println(Courses.getName() +
                    " | " + currentCourses.getSurname() +
                    " | " + currentCourses.getGradeYear());
        }
    }

    private void showOneStudent() {
        System.out.println("View Student\n");
        System.out.println("Enter Student's name:");

        int studentID = scanner.nextInt();
        One one = Student.getOneStudent(studentID);

        System.out.println("Student Name:" + one.name);

        System.out.println("Student Surname:" + one.surname);

    }

    private void studentEnrollment() {
        System.out.println("Type your name please:");
        String name = scanner.nextLine();
        System.out.println("Type your surname:");
        String surname = scanner.nextLine();

        System.out.println("Enter User Type (admin / student):");
        UserType userType = (scanner.nextLine().trim().toUpperCase().equals("ADMIN")) ? UserType.ADMIN : UserType.STUDENT;
        LocalDate createdAt = LocalDate.now();

        Student student = new Student(name,surname, userType, createdAt);
        System.out.println(student.createStudent(student));
    }
}
