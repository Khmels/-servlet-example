<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="servletTags" prefix="st"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <st:emptyTag />

    <st:paramsTag a="10" b="100">
        <%= 100 * 3 %>

    </st:paramsTag>

    <p></p>

    <st:textBodyTag
        iterations="10">
        <tr>
            <td>date:</td>
            <td><st:emptyTag/></td>
            <td><%= 100%></td>
        </tr>
    </st:textBodyTag>

    <st:expressionBodyTag>
        world - is our universe. rabbit - is an animal. java - best programming language"

    </st:expressionBodyTag>
</body>
</html>
