import service.StudentManager;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("""
                    =============QUẢN LÝ SINH VIÊN=============  
                    1. Thêm sinh viên với
                    2. Thêm khóa học mới
                    3. Cập nhật điểm sinh viên
                    4. Hiển thị danh sách sinh viên
                    5. Xóa sinh viên
                    6. Thoát
                    """);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    StudentManager.addStudent(sc);
                    break;
                case 2:
                    StudentManager.addCourse(sc);
                    break;
                case 3:
                    break;
                case 4:
                    StudentManager.displayStudent();
                    break;
                case 5:
                    StudentManager.deleteStudent(sc);
                    break;
                case 6:
                    System.exit(0);
                    System.out.println("Kết thúc chương trình");
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1- 5");
            }

        } while (true);
    }
}