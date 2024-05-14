package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Customer;
import model.Order;
import model.OrderDAO;

import java.io.IOException;
import java.util.List;
@WebServlet("/orders")
public class orderServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OrderDAO service = new OrderDAO();
        Customer customer = (Customer) request.getSession().getAttribute("customer");
        if(customer == null)
            return;
        List<Order> orders = service.doRetrieveAllById(customer.getId());
        request.setAttribute("orders", orders);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/orders.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
