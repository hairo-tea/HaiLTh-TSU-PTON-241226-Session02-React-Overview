package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Product {
    private int id;
    private String name;
    private float price;
    private String title;
    private LocalDate created;
    private String catalog;
    private boolean status;

    public Product() {
    }

    public Product(int id, String name, float price, String title, LocalDate created, String catalog, boolean status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.title = title;
        this.created = created;
        this.catalog = catalog;
        this.status = status;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("ID: %d - Name: %s - Price: %.0f - Tittle: %s\n - Created: %s - Catalog: %s - Status: %s\n", id, name, price, title, created, catalog, status? "Active": "Inactive");
    }

    public void inputData(Scanner scanner) {
        System.out.print("Enter product name: ");
        do {
            String productName = scanner.nextLine().trim();
            if (!productName.isEmpty()) {
                if (productName.length() <= 100) {
                    this.name = productName;
                    break;
                }
            }
            System.err.println("Invalid product name.");
        } while (true);
        System.out.print("Enter product price: ");
        do {
            String productPrice = scanner.nextLine().trim();
            if (!productPrice.isEmpty()) {
                try {
                    Float productPriceFloat = Float.parseFloat(productPrice);
                    if (productPriceFloat > 0) {
                        this.price = productPriceFloat;
                        break;
                    }
                } catch (Exception e) {
                    System.err.println("Invalid product price.");
                }
            }
            System.err.println("Invalid product price.");
        } while (true);
        System.out.print("Enter product title: ");
        do {
            String productTitle = scanner.nextLine().trim();
            if (!productTitle.isEmpty()) {
                this.title = productTitle;
                break;
            }
            System.err.println("Invalid product title.");
        } while (true);
        System.out.print("Enter product created: ");
        do {
            String productCreated = scanner.nextLine().trim();
            if (!productCreated.isEmpty()) {
                try {
                    LocalDate productCreatedDate = LocalDate.parse(productCreated, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    this.created = productCreatedDate;
                    break;
                } catch (Exception e) {
                    System.err.println("Invalid product created.");
                }
            }
            System.err.println("Invalid product created.");

        } while (true);
        System.out.print("Enter product catalog: ");
        do{
            String productCatalog = scanner.nextLine().trim();
            if (!productCatalog.isEmpty()) {
                this.catalog = productCatalog;
                break;
            }
            System.err.println("Invalid product catalog.");
        }while (true);

    }
}
