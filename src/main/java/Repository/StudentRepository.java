package Repository;

import database.DBHandler;
import entity.Student;
import java.sql.*;
import java.util.ArrayList;
public class StudentRepository {
    private DBHandler dbHandler = new DBHandler();

    public void collectStudentInfoAndAddStudent(Student student) throws SQLException {
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

        while(results.next()){
            int id = results.getInt("id");
            String name = results.getString("name");
            String surName = results.getString("surname");
            int gradeYear = results.getInt("gradeYear");
            String created_at = results.getString("created_at");
            String last_updated = results.getString("last_updated");

            students.add(new Student(id, name, surName, gradeYear, created_at, last_updated));
        }

        statement.close();

        return students;
    }
}





