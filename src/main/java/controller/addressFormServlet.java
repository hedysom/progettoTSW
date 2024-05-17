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
@WebServlet("/addressForm")
public class addressFormServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        if(customer == null)
            response.sendRedirect("login");
        Address address = new Address();
        address.setCustomerId(customer.getId());
        address.setCountry(request.getParameter("country"));
        address.setStreet(request.getParameter("street"));
        address.setCity(request.getParameter("city"));
        address.setState(request.getParameter("state"));
        address.setZip(request.getParameter("zip"));
        AddressDAO service = new AddressDAO();
        boolean result = service.doSave(address);
        if(result) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("address");
            dispatcher.forward(request, response);
        }
        else
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Unable to save address");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
