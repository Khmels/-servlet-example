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

    ///hello?name=Tom&age=34&nums=1&nums=2&nums=3.
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
            if(nums !=null) {
                for (String n : nums)
                    writer.print(n + " ");
                writer.println("</h2>");
            }
        } finally {
            writer.close();
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        String name = request.getParameter("username");
        String age = request.getParameter("userage");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String[] courses = request.getParameterValues("courses");

        try {
            writer.println("<p>Name: " + name + "</p>");
            writer.println("<p>Age: " + age + "</p>");
            writer.println("<p>Gender: " + gender + "</p>");
            writer.println("<p>Country: " + country + "</p>");
            writer.println("<h4>Courses</h4>");
            for(String course: courses)
                writer.println("<li>" + course + "</li>");
        } finally {
            writer.close();
        }
    }
}

