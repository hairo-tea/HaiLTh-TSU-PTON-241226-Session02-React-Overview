package dao;

import Entity.Course;
import Entity.Grade;
import Entity.Student;
import util.ConnectionDB;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDao {

    //phương thức addStudent(Student student) để thêm sinh viên mới vào bảng
    public static boolean addStudent(Student student) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call add_student(?,?)}");
            cstmt.setString(1, student.getName());
            cstmt.setString(2, student.getEmail());
            cstmt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return false;
    }

    //kiểm tra sự tồn tại của email
    public static boolean isStudentExists(String email) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call is_email_exists(?,?)}");
            cstmt.setString(1, email);
            cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
            cstmt.execute();
            int cntEmail = cstmt.getInt(2);
            if (cntEmail == 0) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return true;
    }

    //Thêm khóa học mới
    public static boolean addCourse(Course course) {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<Course> courses = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call add_course(?)}");
            cstmt.setString(1,course.getTitle());

            cstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return false;
    }

    //phương thức listStudents() để hiển thị danh sách tất cả sinh viên
    public static List<Student> listStudents() {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<Student> students = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call list_student()}");
            ResultSet rs = cstmt.executeQuery();
            students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setTotalCourses(rs.getInt("total_course"));

                BigDecimal avg = rs.getBigDecimal("avg_grade");
                if (rs.wasNull()) { //sinh viên chưa có điểm
                    avg = null;
                }
                student.setAverageGrade(avg);

                students.add(student);
            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return students;
    }

    public static void updateGrades(int studentID, List<Grade> grades) {

    }

    public static boolean deleteStudent(int studentID) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call delete_student_by_id(?)}");
            cstmt.setInt(1, studentID);
           int result = cstmt.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return false;
    }
}
