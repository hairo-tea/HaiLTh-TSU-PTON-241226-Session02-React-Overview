package Entity;

import java.math.BigDecimal;

public class Grade {
    private int studentID;
    private int courseID;
    private BigDecimal grade;

    public Grade() {
    }

    public Grade(int studentID, int courseID, BigDecimal grade) {
        this.studentID = studentID;
        this.courseID = courseID;
        this.grade = grade;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public BigDecimal getGrade() {
        return grade;
    }

    public void setGrade(BigDecimal grade) {
        this.grade = grade;
    }
}
