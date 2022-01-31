package servlet.others;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.business.ProductDB;

@WebServlet("/delete")
public class DbDeleteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            ProductDB.delete(id);
            response.sendRedirect(request.getContextPath() + "/products-db");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/dbnotfound.jsp").forward(request, response);
        }
    }
}