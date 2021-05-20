package repository;

import database.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Course;

public class CourseRepository {
    private DBHandler dbHandler = new DBHandler();

    public void addCourse(Course course) throws SQLException {
        Connection connection = dbHandler.getConnection();
        String query = "INSERT INTO course(name, start_at, end_at, number_attending) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, course.name);
        preparedStatement.setString(2, course.start_at);
        preparedStatement.setString(3, course.end_at);
        preparedStatement.setInt(4, course.number_attending);

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
            String start_at = results.getString("start_at");
            String end_at = results.getString("end_at");
            int number_attending = results.getInt("number_attending");
            String created_at = results.getString("created_at");
            String last_updated = results.getString("last_updated");


            courses.add(new Course(id, name, start_at, end_at, number_attending, created_at, last_updated));
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
                results.getString("start_at"),
                results.getString("end_at"),
                results.getInt("number_attending"),
                results.getString("created_at"),
                results.getString("last_updated")

        );

        statement.close();

        return course;
    }
}