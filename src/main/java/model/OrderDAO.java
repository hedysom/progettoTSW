package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    public List<Order> doRetrieveAllById(int customerId) {
        List<Order> orders = new ArrayList<>();
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Orders WHERE customersId=?");
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt(1));
                o.setCustomerId(customerId);
                o.setDate(rs.getString(3));
                o.setTotal(rs.getBigDecimal(4));
                orders.add(o);
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
