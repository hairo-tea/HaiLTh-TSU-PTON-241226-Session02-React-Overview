package Entity;

import Validate.Validator;
import dao.StudentDao;

import java.math.BigDecimal;
import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private String email;
    private int totalCourses;
    private BigDecimal averageGrade;

    public Student() {
    }

    public Student(int id, String name, String email, int totalCourses, BigDecimal averageGrade) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.totalCourses = totalCourses;
        this.averageGrade = averageGrade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTotalCourses() {
        return totalCourses;
    }

    public void setTotalCourses(int totalCourses) {
        this.totalCourses = totalCourses;
    }

    public BigDecimal getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(BigDecimal averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return String.format("ID: %d - Name: %s - Email: %s - total courses : %d - average grade : %.1f\n", id, name, email, totalCourses, averageGrade);
    }

    public void inputData(Scanner sc) {
        System.out.print("Nhập tên sinh viên: ");
        do {
            String inputName = sc.nextLine().trim();
            if (Validator.validateName(inputName)) {
                this.name = inputName;
                break;
            }
            System.err.println("Tên không được để trống");

        } while (true);

        System.out.print("Nhập vào email: ");
        do {
            String inputEmail = sc.nextLine().trim();
            if (inputEmail.isEmpty()) {
                System.err.println("Không được để trống");
                continue;
            }
           if (StudentDao.isStudentExists(inputEmail)) {
               System.err.println("Email Không được trùng");
               continue;
           }
           this.email = inputEmail;
           break;

        } while (true);


    }
}
