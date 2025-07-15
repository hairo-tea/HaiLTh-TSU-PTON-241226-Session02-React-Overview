package service;

import dao.ProductDao;
import entity.Product;
import entity.StatisticByStatus;
import entity.StatisticCatalog;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductService {
    public static void displayAllProducts() {
        List<Product> listProduct = ProductDao.displayProducts();
        listProduct.forEach(System.out::println);
    }

    public static void addProduct(Scanner scanner) {
        Product product = new Product();
        product.inputData(scanner);
        boolean result = ProductDao.addProduct(product);
        if (result) {
            System.out.println("Product added successfully");
        } else {
            System.out.println("Something went wrong");
        }
    }

    public static void updateProduct(Scanner scanner) {
        System.out.println("Enter product ID to update:");
        int productId = Integer.parseInt(scanner.nextLine());
        Product product = ProductDao.find_product_id(productId);
        if (product != null) {
            boolean isExist = true;
            do {
                System.out.println("""
                        ===================UPDATE==================
                        1. Enter new product name
                        2. Enter new product price
                        3. Enter new product title
                        4. Enter new created
                        5. Enter new catalog
                        6. Enter new status
                        7. Exit
                        Enter your choice:
                        """);
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Enter new product name:");
                        product.setName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Enter new product price:");
                        product.setPrice(Float.parseFloat(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("Enter new product title:");
                        product.setTitle(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Enter new created:");
                       product.setCreated(LocalDate.parse(scanner.nextLine()));
                        break;
                    case 5:
                        System.out.println("Enter new catalog:");
                        product.setCatalog(scanner.nextLine());
                        break;
                    case 6:
                        System.out.println("Enter new status:");
                      product.setStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 7:
                        isExist = false;
                        break;
                    default:
                        System.err.println("Invalid choice. Please try again");
                }
            } while (isExist);
            //update
            boolean result = ProductDao.updateProduct(product);
            if (result) {
                System.out.println("Product updated successfully");
            }else {
                System.out.println("Something went wrong");
            }
        }else {
            System.out.println("Something went wrong");
        }
    }
    public static void deleteProduct(Scanner scanner) {
        System.out.println("Enter product ID to delete:");
        int productId = Integer.parseInt(scanner.nextLine());
        Product product = ProductDao.find_product_id(productId);
        if (product != null) {
            boolean result = ProductDao.deleteProduct(productId);
            if (result) {
                System.out.println("Product deleted successfully");
            }else{
                System.out.println("Something went wrong");
            }
        }else {
            System.out.println("Something went wrong");
        }
    }
    public static void searchProductByName(Scanner scanner) {
        System.out.println("Enter product name:");
        String productName = scanner.nextLine();
        List<Product> products = ProductDao.findProductByName(productName);
        System.out.println("searched:");
        products.forEach(System.out::println);
    }
    public static void sortProductByPriceAsc() {
        List<Product> listProduct = ProductDao.displayProducts();
        System.out.println("Sorted by price asc:");
        listProduct.stream().sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);
    }
    public static void statisticByCatalog() {
        List<StatisticCatalog> statisticCtl= ProductDao.statisticProductByCatalog();
        statisticCtl.forEach(System.out::println);
    }
    public static void statisticByStatus() {
        List<StatisticByStatus> statistic =ProductDao.statisticByStatus();
        statistic.forEach(System.out::println);
    }
}
