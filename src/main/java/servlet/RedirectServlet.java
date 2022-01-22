package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirects")
public class RedirectServlet extends HttpServlet {

    // localhost:8080/my-app/redirects?id=7
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id == null) {

            String path = request.getContextPath() + "/notfound";
            response.sendRedirect(path);
            //response.sendRedirect("https://www.google.com/");
        }
        else {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            try {
                writer.println("<h2>Hello Id " + id + "</h2>");
            } finally {
                writer.close();
            }
        }
    }
}