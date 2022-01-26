<%@ page import="java.util.Date" pageEncoding="UTF-8" %>
<%@ page import="java.lang.Math, java.text.*" %>
<%@ page import="servlet.others.Calculator" %>

<%
    String[] people = new String[]{"Tom", "Bob", "Sam"};
    String header = "Users list";
%>

<! JSP Declaration - define method>
<%!
    int square(int n){
        return n * n;
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>First JSP App</title>
</head>
<body>

<jsp:include page="header.html" />
<h3><%= header %></h3>

<!JSP Expression >
<p>2 + 2 = <%= 2 + 2 %></p>
<p>5 > 2 = <%= 5 > 2 %></p>
<p><%= new String("Hello").toUpperCase() %></p>
<p>Today <%= new java.util.Date() %></p>

<!JSP Scriplet >
<%
    for(int i = 1; i < 5; i++){
        out.println("<br>Hello " + i);
    }
%>
<br/>
<ul>
    <! JSP Scriplet>


    <%
        /* Пример комментариев внутр и скриплета
        Пример цикла в JSP
        */

        // вывод строки Hello четыре раза

        for(String person: people){
            out.println("<li>" + person + "</li>");
        }
    %>
</ul>

<p><%= square(6) %></p>
<ul>
    <%
        for(int i = 1; i <= 5; i++){
            out.println("<li>" + square(i) + "</li>");
        }
    %>
</ul>

<%-- Комментарии JSP добавляются с помощью тега  "<%--Текст_комментария --'%'>" --%>
<h2>Сегодня: <%= new Date() %></h2>
<h3>Максимум из двух чисел 2 и 3: <%= Math.max(2,3)%></h3>

<h2>Square of 3 = <%= new Calculator().square(3) %></h2>

<jsp:include page="footer.jsp" />


<p>Name: <%= request.getParameter("name") %></p>
<p>Age: <%= request.getParameter("age") %></p>


</body>
</html>
