package servlet.others;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@WebServlet("/expressions")
public class ExpressionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] users = new String[] {"Tom", "Bob", "Sam"};
        req.setAttribute("users", users);

        ArrayList<String> usersList = new ArrayList<String>();
        Collections.addAll(usersList, "Tom", "Bob", "Sam");
        req.setAttribute("usersList", users);

        Cookie cookie = new Cookie("userName", "Sam");
        resp.addCookie(cookie);

        getServletContext().getRequestDispatcher("/express-language.jsp").forward(req, resp);
    }
}
