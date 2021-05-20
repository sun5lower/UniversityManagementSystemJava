package controller;
import entity.Exam;
import entity.Student;
import repository.ExamRepository;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExamController {

    ExamRepository examRepository = new ExamRepository();
    public String createExamList(Exam exam) {

        try {
            examRepository.createExamList(exam);
        } catch (SQLException e) {
            e.printStackTrace();
            return "error with creating exam";
        }
        return "Exam created successfully";
    }

    public ArrayList<Exam> getAll() {
        ArrayList<Exam> exams = new ArrayList<Exam>();
        try {
            exams = examRepository.getAll();
        }catch (SQLException e){
            System.out.println(e);
        }

        return exams;
    }
    public Exam findExamByCourseName(String courseName) {
        Exam exam = null;

        try {
            exam = examRepository.getExam(courseName);
        } catch (SQLException e) {
            System.out.println(e);
        }

        return exam;
    }


}
