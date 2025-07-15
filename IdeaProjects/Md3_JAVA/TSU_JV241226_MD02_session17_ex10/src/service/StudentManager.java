package service;

import Entity.Course;
import Entity.Student;
import dao.StudentDao;

import java.util.List;
import java.util.Scanner;

public class StudentManager {
    public static void addStudent(Scanner sc) {
        Student student = new Student();
        student.inputData(sc);
        boolean result = StudentDao.addStudent(student);
        if (result) {
            System.out.println("Thêm sinh viên thành công");
        }else{
            System.err.println("Thêm sinh viên thất bại");
        }

    }

    public static void addCourse(Scanner sc) {
        Course course = new Course();
        course.inputData(sc);
        boolean result = StudentDao.addCourse(course);
        if (result) {
            System.out.println("Thêm khóa học thành công");
        }else{
            System.err.println("Thêm khóa học thất bại");
        }
    }


    public static void displayStudent() {
        List<Student> listStudent = StudentDao.listStudents();
        listStudent.forEach(System.out::println);
    }
    public static void deleteStudent(Scanner sc) {
        System.out.println("Nhập vào mã sinh viên cần xóa:");
       int id = Integer.parseInt(sc.nextLine());
        boolean result = StudentDao.deleteStudent(id);
        if (result) {
            System.out.println("Xóa thành công");
        }else{
            System.err.println("Xóa thất bại");
        }
    }
}
