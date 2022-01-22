package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class AnotherWayOfServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String[] nums = request.getParameterValues("nums");

        PrintWriter writer = response.getWriter();
        try {
            writer.println("<h2>Hello from HelloServlet</h2>");
            writer.println("<h2>Name: " + name + "; Age: " + age + "</h2>");
            writer.print("<h2>Numbers: ");
            for(String n: nums)
                writer.print(n + " ");
            writer.println("</h2>");
        } finally {
            writer.close();
        }

    }
}

///hello?name=Tom&age=34&nums=1&nums=2&nums=3.