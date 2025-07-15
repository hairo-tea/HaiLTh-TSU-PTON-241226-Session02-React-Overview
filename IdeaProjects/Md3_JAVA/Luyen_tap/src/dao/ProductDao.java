package dao;

import entity.Product;
import entity.StatisticByStatus;
import entity.StatisticCatalog;
import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    public static List<Product> displayProducts() {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<Product> listProducts = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call get_all_product()}");
            ResultSet rs = cstmt.executeQuery();
            listProducts = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setName(rs.getString("product_name"));
                product.setPrice(rs.getInt("product_price"));
                product.setTitle(rs.getString("product_title"));
                product.setCreated(LocalDate.parse(rs.getString("product_created"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                product.setStatus(rs.getBoolean("product_status"));
                listProducts.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return listProducts;
    }

    public static boolean addProduct(Product product) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call create_product(?,?,?,?,?)}");
            cstmt.setString(1, product.getName());
            cstmt.setFloat(2, product.getPrice());
            cstmt.setString(3, product.getTitle());
            cstmt.setDate(4, java.sql.Date.valueOf(product.getCreated()));
            cstmt.setString(5, product.getCatalog());
            cstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return false;
    }

    public static boolean updateProduct(Product product) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call update_product(?,?,?,?,?,?,?)}");
            cstmt.setInt(1, product.getId());
            cstmt.setString(2, product.getName());
            cstmt.setFloat(3, product.getPrice());
            cstmt.setString(4, product.getTitle());
            cstmt.setDate(5, java.sql.Date.valueOf(product.getCreated()));
            cstmt.setString(6, product.getCatalog());
            cstmt.setBoolean(7, product.isStatus());
            cstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return false;
    }

    public static Product find_product_id(int product_id) {
        Connection conn = null;
        CallableStatement cstmt = null;
        Product product = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call get_product_details_by_id(?)}");
            cstmt.setInt(1, product_id);
            ResultSet rs = cstmt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setName(rs.getString("product_name"));
                product.setPrice(rs.getInt("product_price"));
                product.setTitle(rs.getString("product_title"));
                product.setCreated(LocalDate.parse(rs.getString("product_created"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                product.setStatus(rs.getBoolean("product_status"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return product;
    }

    public static boolean deleteProduct(int product_id) {
        Connection conn = null;
        CallableStatement cstmt = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call delete_product(?)}");
            cstmt.setInt(1, product_id);
            cstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return false;
    }

    public static List<Product> findProductByName(String name) {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<Product> listProducts = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call search_product_by_name(?)}");
            cstmt.setString(1, name);
            ResultSet rs = cstmt.executeQuery();
            listProducts = new ArrayList<>();
            if (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setName(rs.getString("product_name"));
                product.setPrice(rs.getInt("product_price"));
                product.setTitle(rs.getString("product_title"));
                product.setCreated(LocalDate.parse(rs.getString("product_created"), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                product.setCatalog(rs.getString("product_catalog"));
                product.setStatus(rs.getBoolean("product_status"));
                listProducts.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return listProducts;
    }

    public static List<StatisticCatalog> statisticProductByCatalog() {
        Connection conn = null;
        CallableStatement cstmt = null;
        List<StatisticCatalog> statisticCatalogs = null;
        try {
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call statistic_product_by_catalog()}");
            ResultSet rs = cstmt.executeQuery();
            statisticCatalogs = new ArrayList<>();
            while (rs.next()) {
                StatisticCatalog statisticCtl = new StatisticCatalog();
                statisticCtl.setCatalog(rs.getString("product_catalog"));
                statisticCtl.setCntProducts(rs.getInt("cntProduct"));
                statisticCatalogs.add(statisticCtl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return statisticCatalogs;
    }
    public static List<StatisticByStatus> statisticByStatus(){
        Connection conn = null;
        CallableStatement cstmt = null;
        List<StatisticByStatus> listProducts = null;
        try{
            conn = ConnectionDB.openConnection();
            cstmt = conn.prepareCall("{call statistic_product_by_status()}");
            ResultSet rs = cstmt.executeQuery();
            listProducts = new ArrayList<>();
            while (rs.next()) {
                StatisticByStatus sttByStatus = new StatisticByStatus();
                sttByStatus.setStatus(rs.getBoolean("product_status"));
                sttByStatus.setCntStatus(rs.getInt("cntProduct_status"));
                listProducts.add(sttByStatus);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnection(conn, cstmt);
        }
        return listProducts;
    }

}
