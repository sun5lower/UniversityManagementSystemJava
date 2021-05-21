package repository;

import database.DBHandler;

import entity.CourseEnrollment;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Course;

public class CourseRepository {
    private DBHandler dbHandler = new DBHandler();

    public void addCourse(Course course) throws SQLException {
        Connection connection = dbHandler.getConnection();
        String query = "INSERT INTO course(name) VALUES(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, course.name);


        preparedStatement.execute();
        preparedStatement.close();
    }

    public ArrayList<Course> getAll() throws SQLException {
        Statement statement = dbHandler.getConnection().createStatement();
        String query = "SELECT * FROM course";
        ResultSet results = statement.executeQuery(query);

        ArrayList<Course> courses = new ArrayList<Course>();

        while (results.next()) {
            int id = results.getInt("id");
            String name = results.getString("name");
            String created_at = results.getString("created_at");
            String last_updated = results.getString("last_updated");


            courses.add(new Course(id, name, created_at, last_updated));
        }

        statement.close();

        return courses;
    }


    public Course findCourseByID(Integer id) throws SQLException {
        Course course;

        Statement statement = dbHandler.getConnection().createStatement();
        String query = "SELECT * FROM course WHERE id =" + id + " LIMIT 1";

        ResultSet results = statement.executeQuery(query);

        results.next();
        course = new Course(
                results.getInt("id"),
                results.getString("name"),
                results.getString("created_at"),
                results.getString("last_updated")

        );

        statement.close();

        return course;
    }

    public void addCourseEnrollment(CourseEnrollment courseEnrollment) throws SQLException{
        Connection connection = dbHandler.getConnection();
        String query = "INSERT INTO courseRegistration(studentId, courseId) VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, courseEnrollment.studentId);
        preparedStatement.setInt(2, courseEnrollment.courseId);

        preparedStatement.execute();
        preparedStatement.close();
    }

    public ArrayList<Course> findCourseEnrollmentByStudentId(int studentId)  throws SQLException {
        Statement statement = dbHandler.getConnection().createStatement();
        String query = "select * from course "
                + "inner join courseRegistration on course.id = courseRegistration.courseId "
                + "where courseRegistration.studentId = "+ studentId;

        ResultSet results = statement.executeQuery(query);
        ArrayList<Course> courses = new ArrayList<Course>();

        while (results.next()) {
            int id = results.getInt("id");
            String name = results.getString("name");
            String created_at = results.getString("created_at");
            String last_updated = results.getString("last_updated");

            courses.add(new Course(id, name,  created_at, last_updated));
        }

        statement.close();

        return courses;
    }
}