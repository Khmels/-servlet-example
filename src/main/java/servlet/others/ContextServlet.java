package servlet.others;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ContextServlet extends HttpServlet {

    // Контекст запроса
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        request.setAttribute("name", "Tom");
//        request.setAttribute("age", 34);
//
//        getServletContext().getRequestDispatcher("/basic.jsp").forward(request, response);
//    }

    // Контекст приложения
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        ServletContext servletContext = getServletContext();
//        servletContext.setAttribute("name", "Tom");
//        servletContext.setAttribute("age", 35);
//
//        getServletContext().getRequestDispatcher("/basic.jsp").forward(request, response);
//    }

    // Контекст сессии
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.setAttribute("name", "Tom");
        session.setAttribute("age", 34);

        getServletContext().getRequestDispatcher("/basic.jsp").forward(request, response);
    }
}