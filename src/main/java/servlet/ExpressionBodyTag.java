package servlet;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ExpressionBodyTag extends BodyTagSupport {
    @Override
    public int doAfterBody() throws JspException {
        String body = getBodyContent().getString();
        JspWriter enclosingWriter = getBodyContent().getEnclosingWriter();

        String tableBody = Arrays.stream(body.split("\\."))
                .map(sentence -> {
                    String[] parts = sentence.split("-");
                    return String.format("<tr><td>%s</td><td>%s</td>", parts[0], parts[1]);
                }).collect(Collectors.joining());

        try {
            enclosingWriter.write("<table>");
            enclosingWriter.write(tableBody);
            enclosingWriter.write("</table>");
        } catch (IOException e) {
            throw new JspException(e);
        }

        return EVAL_PAGE;
    }
}

