package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Address;
import model.AddressDAO;
import model.Customer;

import java.io.IOException;
@WebServlet("/modifyAddress")
public class modifyAddressServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        if(customer == null)
            response.sendRedirect("login");
        AddressDAO service = new AddressDAO();
        RequestDispatcher dispatcher = request.getRequestDispatcher("address");
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("delete address")){
            int addressId= Integer.parseInt(request.getParameter("addressId"));
            service.doDeletebyIds(customer.getId(), addressId);
        }
        if(action.equalsIgnoreCase("modify address")){
            Address address = new Address();
            address.setCustomerId(customer.getId());
            address.setId(Integer.parseInt(request.getParameter("addressId")));
            address.setCountry(request.getParameter("country"));
            address.setStreet(request.getParameter("street"));
            address.setCity(request.getParameter("city"));
            address.setState(request.getParameter("state"));
            address.setZip(request.getParameter("zip"));
            service.doUpdate(address);
        }
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
