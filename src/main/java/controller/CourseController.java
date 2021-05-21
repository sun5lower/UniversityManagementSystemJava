package controller;
import entity.Course;
import entity.CourseEnrollment;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Student;
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

    public String enrollStudent(CourseEnrollment courseEnrollment){
        try {
            courseRepository.addCourseEnrollment(courseEnrollment);
        } catch (SQLException e) {
            e.printStackTrace();
            return "error with enrolling student";
        }
        return "Student enrolled successfully";
    }

    public ArrayList<Course> findCoursesEnrolledByStudent(int studentId) {
        ArrayList<Course> courses = new ArrayList<Course>();
        try {
            courses = courseRepository.findCourseEnrollmentByStudentId(studentId);
        }catch (SQLException e){
            System.out.println(e);
        }

        return courses;
    }


}
