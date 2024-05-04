package model;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerDAO {



    public Customer doRetrieveById(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id, firstName, lastName, email FROM customers WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer p = new Customer();
                p.setId(rs.getInt(1));
                p.setFirstName(rs.getString(2));
                p.setLastName(rs.getString(3));
                p.setEmail(rs.getString(4));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean doSave(Customer customer) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO customers(firstName, lastName, email, passwordHash) VALUES(?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPasswordHash());
            if (ps.executeUpdate() != 1) {
                return false;
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            customer.setId(id);
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Customer customer) {
        try(Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE customers SET firstName=?, lastName=?, email=? WHERE id=?");
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getEmail());
            ps.setInt(4, customer.getId());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> doRetrieveAll() {
        try (Connection con = ConPool.getConnection()) {
            List<Customer> customers = new ArrayList<>();
            PreparedStatement ps =
                    con.prepareStatement("SELECT * from customers");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Customer p = new Customer();
                p.setId(rs.getInt("id"));
                p.setFirstName(rs.getString("firstName"));
                p.setLastName(rs.getString("lastName"));
                p.setEmail(rs.getString("email"));
                customers.add(p);
            }
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isAdmin(int id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id FROM admins WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // If the user's ID is in the admin table, rs.next() will be true
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Customer doRetrieveByEmailPassword(String email, String password) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps =
                    con.prepareStatement("SELECT id, firstName, lastName, email FROM customers WHERE email=? AND passwordHash=SHA1(?)");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer p = new Customer();
                p.setId(rs.getInt(1));
                p.setFirstName(rs.getString(2));
                p.setLastName(rs.getString(3));
                p.setEmail(rs.getString(4));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}


