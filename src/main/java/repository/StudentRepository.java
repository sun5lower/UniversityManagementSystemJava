package repository;
import database.DBHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Course;
import entity.Exam;
import entity.Student;

public class StudentRepository {
    private DBHandler dbHandler = new DBHandler();

    public void addStudent(Student student) throws SQLException {
        Connection connection = dbHandler.getConnection();
        String query = "INSERT INTO student(name, surName, gradeYear) VALUES(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, student.getName());
        preparedStatement.setString(2, student.getSurname());
        preparedStatement.setInt(3, student.getGradeYear());
        preparedStatement.execute();

        preparedStatement.close();
    }


    public ArrayList<Student> getAll() throws SQLException {
        Statement statement = dbHandler.getConnection().createStatement();
        String query = "SELECT * FROM student";
        ResultSet results = statement.executeQuery(query);

        ArrayList<Student> students = new ArrayList<Student>();

        while (results.next()) {
            int id = results.getInt("id");
            String name = results.getString("name");
            String surName = results.getString("surname");
            int gradeYear = results.getInt("gradeYear");
            String courseEnrolled = results.getString ("courseEnrolled");
            String created_at = results.getString("created_at");
            String last_updated = results.getString("last_updated");

            students.add(new Student(id, name, surName, gradeYear,courseEnrolled, created_at, last_updated));
        }

        statement.close();

        return students;
    }



    public Student findStudentByID(Integer id) throws SQLException {
        Student student;

        Statement statement = dbHandler.getConnection().createStatement();
        String query = "SELECT * FROM student WHERE id =" + id + " LIMIT 1";

        ResultSet results = statement.executeQuery(query);

        results.next();
        student = new Student(
                results.getInt("id"),
                results.getString("name"),
                results.getString("surName"),
                results.getInt("gradeYear"),
                results.getString("courseEnrolled"),
                results.getString("created_at"),
                results.getString("last_updated")
        );

        statement.close();

        return student;
    }




   }







