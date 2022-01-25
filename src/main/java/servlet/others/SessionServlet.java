package servlet.others;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // получаем сессию
        HttpSession session = request.getSession();
        // получаем объект name
        String name = (String) session.getAttribute("name");
        Person tom = (Person) session.getAttribute("person");

        // установка интервала неактивности
        session.setMaxInactiveInterval(60*60*24);   // 1 день
        session.setMaxInactiveInterval(-1); // до закрытия браузера

        // получение всех ключей
        Enumeration keys = session.getAttributeNames();

        // удаление всех данных из сессии
        //session.invalidate();

        PrintWriter out = response.getWriter();
        try {
            while(keys.hasMoreElements()){
                out.println((String) keys.nextElement());
            }

            // если объект ранее не установлен
            if(name == null) {
                // устанавливаем объект с ключом name
                session.setAttribute("name", "Sam Johnson");
                out.println("Session data are set");
            }
            else {
                out.println("Name: " + name);
                // удаляем объект с ключом name
                session.removeAttribute("name");
            }

            if(tom == null) {

                tom = new Person("Tom", 34);
                session.setAttribute("person", tom);
                out.println("Session complex data are set");
            }
            else {
                out.println("Name: " + tom.getName() + " Age: " + tom.getAge());
                session.invalidate();
            }
        }
        finally {
            out.close();
        }
    }
}
