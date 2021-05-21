package entity;

public class Exam {
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int courseId;
    public int studentId;
    public String courseName;
    public String examDate;
    public String studentName;
    public int result;

    public Exam (String courseName, String examDate, String studentName, int result) {
        this.courseName = courseName;
        this.examDate = examDate;
        this.studentName = studentName;
        this.result = result;
    }

    public Exam() {
    }

    public Exam(int id, String courseName, String examDate, String studentName, int result, String created_at, String last_updated) {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}