import service.ProductService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("""
                    ********************PRODUCT MANAGEMENT****************
                    1. Danh sách sản phẩm
                    2. Thêm mới sản phẩm
                    3. Cập nhật sản phẩm
                    4. Xóa sản phẩm
                    5. Tìm kiếm sản phẩm theo tên sản phẩm
                    6. Sắp xếp sản phẩm theo giá tăng dần
                    7. Thống kê số lượng sản phẩm theo danh mục
                    8. Thống kê số lượng sản phẩm theo trạng thái
                    9. Thoát
                    Lựa chọn của bạn: 
                    """);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    ProductService.displayAllProducts();
                    break;
                case 2:
                    ProductService.addProduct(sc);
                    break;
                case 3:
                    ProductService.updateProduct(sc);
                    break;
                case 4:
                    ProductService.deleteProduct(sc);
                    break;
                case 5:
                    ProductService.searchProductByName(sc);
                    break;
                case 6:
                    ProductService.sortProductByPriceAsc();
                    break;
                case 7:
                    ProductService.statisticByCatalog();
                    break;
                case 8:
                    ProductService.statisticByStatus();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng lựa chọn từ 1- 7");
            }
        } while (true);
    }
}