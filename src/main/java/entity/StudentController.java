package entity;

import Repository.StudentRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentController {
StudentRepository studentRepository = new StudentRepository();

    public ArrayList<Student> getAll() {
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
