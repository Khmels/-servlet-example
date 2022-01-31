package servlet.others;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql.business.Product;
import mysql.business.ProductDB;


@WebServlet("/edit")
public class DbEditServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = ProductDB.selectOne(id);
            if(product!=null) {
                request.setAttribute("product", product);
                getServletContext().getRequestDispatcher("/dbedit.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/dbnotfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/dbnotfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name1 = request.getParameter("name");
        String price1 = request.getParameter("price");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            long price = Long.parseLong(request.getParameter("price"));
            Product product = new Product(id, name, price);
            ProductDB.update(product);
            response.sendRedirect(request.getContextPath() + "/products-db");
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/dbnotfound.jsp").forward(request, response);
        }
    }
}
