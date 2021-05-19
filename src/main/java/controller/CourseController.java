package controller;
import entity.Course;
import entity.Student;
import java.sql.SQLException;
import java.util.ArrayList;
import repository.CourseRepository;
public class CourseController {

    CourseRepository courseRepository = new CourseRepository();
    public String addCourse(Course course) {

        try {
            courseRepository.addCourse(course);
        } catch (SQLException e) {
            e.printStackTrace();
            return "error with adding student";
        }
        return "Course added successfully";
    }

    public ArrayList<Student> getAll() {
        ArrayList<Student> students = new ArrayList<Student>();
        try {
            students = studentRepository.getAll();
        }catch (SQLException e){
            System.out.println(e);
        }

        return students;
    }



    public Student findStudentByID(Integer id){
        Student student  = null;

        try {
            student = studentRepository.findStudentByID(id);
        }catch (SQLException e){
            System.out.println(e);
        }

        return student;
    }

}
}
