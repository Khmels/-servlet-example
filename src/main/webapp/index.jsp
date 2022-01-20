<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<%
    String[] tagTypes = new String[] { "for", "if", "case", "import" };
    request.setAttribute("urls", tagTypes);
%>
</body>
</html>
