package servlet.others;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mysql.business.Product;
import mysql.business.ProductDB;

@WebServlet("/create")
public class DbCreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/dbcreate.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String name = request.getParameter("name");
            long price = Long.parseLong(request.getParameter("price"));
            Product product = new Product(name, price);
            ProductDB.insert(product);
            response.sendRedirect(request.getContextPath()+"/products-db");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/dbcreate.jsp").forward(request, response);
        }
    }
}