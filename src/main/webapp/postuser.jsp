<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>User Info</title>
</head>
<body>
<p>Name: <%= request.getParameter("name") %></p>
<p>Age: <%= request.getParameter("age") %></p>
<br/>
<p style="margin-left: 40px">Name: ${param.name}</p>
<br/><i>После "paramValues" идет название параметра, причем параметр фактически представляет массив,
    <br/>и через индексы мы можем получить отдельные введенные данные.</i>
<br>
<br> Phone 1: $_{paramValues.phone[0]}
<p style="margin-left: 40px">Phone 1: ${paramValues.phone[0]}</p>
<p style="margin-left: 40px">Phone 2: ${paramValues.phone[1]}</p>
</body>
</html>
