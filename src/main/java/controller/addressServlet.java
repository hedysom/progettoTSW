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
import java.util.List;
@WebServlet("/address")
public class addressServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddressDAO service = new AddressDAO();
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        List<Address> addresses=service.doRetrieveByCustomerId(customer.getId());
        request.setAttribute("addresses", addresses);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/address.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
