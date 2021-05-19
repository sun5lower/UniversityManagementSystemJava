package entity;
import java.time.LocalDate;
import java.util.Scanner;

public class Student {
    public int id;
    public String name;
    public String surname;
    public int gradeYear;
    public String courseEnrolled;

    public String last_updated;
    public String created_at;

    public Student() {
    }

    public Student(int id, String name, String surname, int gradeYear, String courseEnrolled, String last_updated, String created_at) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gradeYear = gradeYear;
        this.courseEnrolled = courseEnrolled;
        this.last_updated = last_updated;
        this.created_at = created_at;
    }

    public Student(int id, String name, String surName, int greadYear, String created_at, String last_updated) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGradeYear() {
        return gradeYear;
    }

    public void setGradeYear(int gradeYear) {
        this.gradeYear = gradeYear;
    }

    public String getCourseEnrolled() {
        return courseEnrolled;
    }

    public void setCourseEnrolled(String courseEnrolled) {
        this.courseEnrolled = courseEnrolled;
    }

    public String getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(String last_updated) {
        this.last_updated = last_updated;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
}
    /*

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGradeYear() {
        return gradeYear;
    }

    public void setGradeYear(int gradeYear) {
        this.gradeYear = gradeYear;
    }

    /*


    /*constructor will ask for name ,year
    generate ID
    enroll in classes
    view balance
    pay for classes



    private String courses = "";
    //static means value is not specific to object,but to class
    private int costOfCoursesBalance = 0;
    private static int tuitionFees = 400;

    public Student(String name, String surname, LocalDate createdAt) {
    }

    public Student(int id, String name, String surName, int gradeYear, String created_at, String last_updated) {
    }

    public Student(String name, String surname, String gradeYear) {
    }


    public static <One> One getOneStudent(int studentID) {
        return null;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public int getCostOfCoursesBalance() {
        return costOfCoursesBalance;
    }

    public void setCostOfCoursesBalance(int costOfCoursesBalance) {
        this.costOfCoursesBalance = costOfCoursesBalance;
    }

    public static int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public String getName() {
        return name;
    }

    public static void setName(String name) {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getGradeYear() {
        return gradeYear;
    }

    public void setGradeYear(int gradeYear) {
        this.gradeYear = gradeYear;
    }

    public Student(String name, String surname, int gradeYear, String courses, int costOfCoursesBalance) {
        this.name = name;
        this.surname = surname;
        this.gradeYear = gradeYear;
        this.courses = courses;
        this.costOfCoursesBalance = costOfCoursesBalance;
    }

    public Student() {

        System.out.println("Hello, welcome to new year at school!");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        this.name = scanner.nextLine();

        System.out.print("Please enter your surname: ");
        this.surname = scanner.nextLine();

        System.out.println("What year are you at? ");
        System.out.print("1 - 1st year\n2 - 2nd year\n3 - 3rd year\n4 - 4th year ");
        this.gradeYear = scanner.nextInt();


        // every next students id will be 1 greater than previous

    }

    //join the classes
    public void enroll() {
        //make a loop
        do {
            System.out.print("Enter class you want to join( x to quit): ");
            Scanner scanner = new Scanner(System.in);
            String course = scanner.nextLine();
            if (!course.equals("x")) {
                course = course + "\n " + course;
                costOfCoursesBalance = costOfCoursesBalance + tuitionFees;
            } else {
                break;
            }
        } while (1 != 0);

    }

    //view balance
    public void viewBalance() {
        System.out.println("Your balance is £" + costOfCoursesBalance);
    }

    //study fees
    public void payForStudies() {
        viewBalance();
        System.out.println("How much would you like to pay? ");
        Scanner scanner = new Scanner(System.in);
        int payment = scanner.nextInt();
        costOfCoursesBalance = costOfCoursesBalance - payment;
        System.out.println("Thank you for your payment of £" + payment);
        viewBalance();
    }

    //view status
    public String toString() {
        return "Name: " + name + " " + surname +
                "\nGrade Level: " + gradeYear +
                "\nClasses enrolled: " + courses +
                "\nBalance: £" + costOfCoursesBalance;
    }

    public boolean createStudent(Student student) {

        return false;
    }

    public String setName() {
        return name;*/