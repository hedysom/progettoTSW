package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Address;
import model.AddressDAO;

import java.io.IOException;

@WebServlet("/modifyAddressForm")
public class modifyAddressFormServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int customerID = Integer.parseInt(request.getParameter("customerId"));
        int addressID = Integer.parseInt(request.getParameter("addressId"));
        Address address = new Address();
        AddressDAO service = new AddressDAO();
        address = service.doRetrieveByIds(customerID, addressID);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/modifyAddressForm.jsp");
        request.setAttribute("address", address);
        dispatcher.forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
