package servlet.others;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jstl-example")
public class JstlExampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "<script>alert('Hello gold')</script>");
        String[] users = new String[]{"Tom", "Bob", "Sam"};
        req.setAttribute("users", users);
        req.setAttribute("isVisible", true);
        req.setAttribute("val", 1);
        getServletContext().getRequestDispatcher("/jstlexample.jsp").forward(req, resp);
    }
}
