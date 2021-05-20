package controller;
import entity.Course;
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
            return "error with adding course";
        }
        return "Course added successfully";
    }

    public ArrayList<Course> getAll() {
        ArrayList<Course> courses = new ArrayList<Course>();
        try {
            courses = courseRepository.getAll();
        }catch (SQLException e){
            System.out.println(e);
        }

        return courses;
    }


    public Course findCourseByID(Integer id){
        Course course  = null;

        try {
            course = courseRepository.findCourseByID(id);
        }catch (SQLException e){
            System.out.println(e);
        }

        return course;
    }


}
