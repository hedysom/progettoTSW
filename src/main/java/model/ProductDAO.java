package model;

import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductDAO {



    public Product doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM products WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setPrice(rs.getBigDecimal(4));
                p.setStock(rs.getInt(5));
                p.setCategory(rs.getString(6));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void doSave(Product product) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO products(name, description, price, stock, category)  VALUES(?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setBigDecimal(3, product.getPrice());
            ps.setInt(4, product.getStock());
            ps.setString(5,product.getCategory());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            product.setId(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Product product) {
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE customers SET name=?, description=?, price=? ,stock=?, category=? WHERE id=?");
            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setBigDecimal(3, product.getPrice());
            ps.setString(4, product.getCategory());
            ps.setInt(5, product.getId());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> doRetrieveAll() {
        try (Connection con = ConPool.getConnection()) {
            List<Product> customers = new ArrayList<>();
            PreparedStatement ps =
                    con.prepareStatement("SELECT * from products");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("Name"));
                p.setDescription(rs.getString("Description"));
                p.setPrice(rs.getBigDecimal("Price"));
                p.setStock(rs.getInt("Stock"));
                p.setCategory(rs.getString("Category"));
                customers.add(p);
            }
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> doRetrieveAllByCategory(String Category){

        try (Connection con = ConPool.getConnection()) {
            List<Product> customers = new ArrayList<>();
            PreparedStatement ps =
                    con.prepareStatement("SELECT * from products where Category = ?");
            ps.setString(1, Category);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("Name"));
                p.setDescription(rs.getString("Description"));
                p.setPrice(rs.getBigDecimal("Price"));
                p.setStock(rs.getInt("Stock"));
                p.setCategory(rs.getString("Category"));
                customers.add(p);
            }
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}


