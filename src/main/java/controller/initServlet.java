package controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import model.Category;
import model.CategoryDAO;
import model.ConPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/init", loadOnStartup = 0)
public class initServlet extends HttpServlet {
    public void init() {
        try (Connection con = ConPool.getConnection()) {
            CategoryDAO service = new CategoryDAO();
            List<Category> categories = service.doRetrieveAll();
            ServletContext context = getServletContext();
            context.setAttribute("categories", categories);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
