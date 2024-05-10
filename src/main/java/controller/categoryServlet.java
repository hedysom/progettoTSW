package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import model.ProductDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/category")
public class categoryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDAO service = new ProductDAO();
        String category = request.getParameter("category");
        List<Product> products = service.doRetrieveAllByCategory(category);
        request.setAttribute("category", category);
        request.setAttribute("products", products);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/category.jsp");
        dispatcher.forward(request,response);
    }
}
