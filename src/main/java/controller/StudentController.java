package controller;

import Repository.StudentRepository;
import entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentController {
StudentRepository studentRepository = new StudentRepository();

    public String collectStudentInfoAndAddStudent(Student student) {

        try {
            studentRepository.collectStudentInfoAndAddStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
            return "error with adding student";
        }
        return "Student added successfully";
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            students = studentRepository.getAll();
        }catch (SQLException e){
            System.out.println(e);
        }

        return students;
    }
    public Student findStudent(String name){
        return new Student();
    }

}
