package servlet.others;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/params", "/params-exception"})
public class ContextAndInitParamsServlet extends HttpServlet {

    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        //этот параметр будет доступен для всех сервлетов в приложении
        String parameter = getServletContext().getInitParameter("message");

        // uri /params - null
        // uri /params-from-Xml - null
        String message = getServletConfig().getInitParameter("message");

        String number = request.getParameter("number");
        double x = 1/Integer.parseInt(number);

        response.setContentType("text/html");

        try (PrintWriter writer = response.getWriter()) {
            writer.println("<h2> getServletContext().getInitParameter : " + parameter + "</h2>");
            writer.println("<h2> getServletConfig().getInitParameter: " + message + "</h2>");
            writer.println("<h2> Result:" + x + "</h2>");
        }
    }
}
