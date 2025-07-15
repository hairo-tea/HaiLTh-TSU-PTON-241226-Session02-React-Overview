package Entity;

import java.util.Scanner;

public class Course {
    private int id;
    private String title;

    public Course() {
    }
    public Course(int id, String title) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void inputData(Scanner sc) {
        System.out.println("Nhập tên khóa học: ");
        this.title = sc.nextLine();
    }
}
