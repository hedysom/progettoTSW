package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                a.setStreet(rs.getString(2));
                a.setCity(rs.getString(3));
                a.setZip(rs.getString(4));
                a.setState(rs.getString(5));
                a.setCountry(rs.getString(6));
                addresses.add(a);
            }
        } catch (SQLException e) {
          throw new RuntimeException(e);
        }
        return addresses;
    }
}
