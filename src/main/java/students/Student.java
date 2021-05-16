package students;

import java.util.Scanner;

public class Student {
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
    }
}