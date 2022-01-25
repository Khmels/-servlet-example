package servlet.others;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet ("/set-cookies")
public class SetCookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        String site = req.getRequestURL()
                .substring(0,req.getRequestURL().length()-req.getRequestURI().length());
        try {
            resp.addCookie(new Cookie("user", "Tom"));
            out.println("Cookie is set");
            out.println("<br/><a href=\""+site+req.getContextPath() + "/get-cookies\">Get cookies</a>");
        }
        finally {
            out.close();
        }
    }
}
