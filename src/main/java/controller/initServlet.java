package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import model.ConPool;

@WebServlet(loadOnStartup = 0)
public class initServlet extends HttpServlet {
    public void init(){
        ConPool service = new ConPool();


    }
}
