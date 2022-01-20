package servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/another-way", "/cool-servlet/*"})
public class MainServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);         // следует вызывать вначале
        log("Method init =)");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Method service enter\n\n");
        super.service(req, resp);
        resp.getWriter().write("Method service exit\n\n");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uri = req.getRequestURI();
        log ("uri: " + uri);
        StringBuffer requestURL = req.getRequestURL();
        log ("url: " + requestURL);
        String parameterMap = formatParams(req);
        resp.getWriter().write("Method doGet:\n " + uri + "\nParams:\n" + parameterMap + "\n" );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String parameterMap = formatParams(req);
        resp.getWriter().write("Method doPost:\n " + uri + "\n\nParams:\n" + parameterMap + "\n" );
    }

    private String formatParams(HttpServletRequest req) {
        return req.getParameterMap()
                .entrySet()
                .stream()
                .map(entry -> {
                    String param = String.join(" and ", entry.getValue());
                    return entry.getKey() + " => " + param;
                })
                .collect(Collectors.joining("\n"));
    }

    @Override
    public void destroy() {
        log("Method destroy =)");
    }
}
