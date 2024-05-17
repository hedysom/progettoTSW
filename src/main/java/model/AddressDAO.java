package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO {
    public List<Address> doRetrieveByCustomerId(int customerId) {
        List<Address> addresses = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Addresses WHERE customerId=?");
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Address a = new Address();
                a.setId(rs.getInt(1));
                a.setCustomerId(customerId);
                a.setStreet(rs.getString(3));
                a.setCity(rs.getString(4));
                a.setZip(rs.getString(5));
                a.setState(rs.getString(6));
                a.setCountry(rs.getString(7));
                addresses.add(a);
            }
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
        return addresses;
    }

    public boolean doSave(Address address) {
        try (Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO Addresses(customerId, street, city, zip, state, country) " +
                    "VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, address.getCustomerId());
            ps.setString(2, address.getStreet());
            ps.setString(3, address.getCity());
            ps.setString(4, address.getZip());
            ps.setString(5, address.getState());
            ps.setString(6, address.getCountry());
            if (ps.executeUpdate() != 1) {
                return false;
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            address.setId(id);
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Address doRetrieveByIds(int customerId, int addressId) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Addresses WHERE customerId=? AND id=?");
            ps.setInt(1, customerId);
            ps.setInt(2, addressId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Address a = new Address();
                a.setId(rs.getInt(1));
                a.setCustomerId(customerId);
                a.setStreet(rs.getString(3));
                a.setCity(rs.getString(4));
                a.setZip(rs.getString(5));
                a.setState(rs.getString(6));
                a.setCountry(rs.getString(7));
                return a;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doDeletebyIds(int customerId, int addressId){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM Addresses WHERE customerId=? AND id=?");
            ps.setInt(1, customerId);
            ps.setInt(2, addressId);
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("DELETE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void doUpdate(Address address) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Addresses SET street=?, city=?, zip=?, state=?, country=? WHERE id=?");
            ps.setString(1, address.getStreet());
            ps.setString(2, address.getCity());
            ps.setString(3, address.getZip());
            ps.setString(4, address.getState());
            ps.setString(5, address.getCountry());
            ps.setInt(6, address.getId());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("UPDATE error.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
