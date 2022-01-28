package servlet.others;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserSerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserSer tom = new UserSer("Tom", 25);
        request.setAttribute("userSer", tom);
        getServletContext()
                .getRequestDispatcher("/user.jsp")
                .forward(request, response);
    }
}
