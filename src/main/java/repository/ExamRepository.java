package repository;
import database.DBHandler;
import entity.Exam;
import java.sql.*;
import java.util.ArrayList;
public class ExamRepository {

    private DBHandler dbHandler = new DBHandler();

    public void createExamList(Exam exam) throws SQLException {
        Connection connection = dbHandler.getConnection();
        String query = "INSERT INTO ExamList(courseId, examDate, studentId, result) VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, exam.getCourseId());
        preparedStatement.setString(2, exam.getExamDate());
        preparedStatement.setInt(3, exam.getStudentId());
        preparedStatement.setInt(4, exam.getResult());
        preparedStatement.execute();

        preparedStatement.close();
    }

    public ArrayList<Exam> getAll() throws SQLException {
        Statement statement = dbHandler.getConnection().createStatement();
        String query = "select student.name as studentName, course.name as courseName, ExamList.result, ExamList.examDate "
                + "from ExamList "
                + "inner join course on courseId = ExamList.courseId "
                + "inner join student on studentId = ExamList.studentId "
                + "where 1";
        ResultSet results = statement.executeQuery(query);

        ArrayList<Exam> exams = new ArrayList<Exam>();

        while (results.next()) {
            int id = results.getInt("id");
            String courseName = results.getString("courseName");
            String examDate = results.getString("examDate");
            String studentName = results.getString("studentName");
            int result = results.getInt ("result");
            String created_at = results.getString("created_at");
            String last_updated = results.getString("last_updated");

            exams.add (new Exam (id, courseName, examDate, studentName, result,created_at,last_updated));
        }

        statement.close();

        return exams;
    }

    public ArrayList<Exam> getStudentExams(int studentId) throws SQLException {
        Statement statement = dbHandler.getConnection().createStatement();
        String query = "select student.name as studentName, course.name as courseName, ExamList.result, ExamList.examDate "
                + "from ExamList "
                + "inner join course on course.id = ExamList.courseId "
                + "inner join student on student.id = ExamList.studentId "
                + "where ExamList.studentId = "+ studentId;
        ResultSet results = statement.executeQuery(query);

        ArrayList<Exam> exams = new ArrayList<Exam>();

        while (results.next()) {
            int id = results.getInt("id");
            String courseName = results.getString("courseName");
            String examDate = results.getString("examDate");
            String studentName = results.getString("studentName");
            int result = results.getInt ("result");
            String created_at = results.getString("created_at");
            String last_updated = results.getString("last_updated");

            exams.add (new Exam (id, courseName, examDate, studentName, result,created_at,last_updated));
        }

        statement.close();

        return exams;
    }

    public Exam getExam(String courseName) throws SQLException {
        Exam exam;

        Statement statement = dbHandler.getConnection().createStatement();
        String query = "SELECT * FROM ExamList WHERE courseName LIKE '%" + courseName + "%'";

        ResultSet results = statement.executeQuery(query);

        results.next();
        exam = new Exam(
                results.getInt("id"),
                results.getString("courseName"),
                results.getString("examDate"),
                results.getString("studentName"),
                results.getInt("result"),
                results.getString("created_at"),
                results.getString("last_updated")
        );

        statement.close();

        return exam;
    }
}
