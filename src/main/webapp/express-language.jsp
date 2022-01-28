<%
    pageContext.setAttribute("name", "Tom");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Application</title>
</head>
<body>
<p>Name: ${name}</p>
<p>Name: ${requestScope.name}</p>
<div>
    <p>
        EL пытается найти значения для этих данных во всех доступных контекстах.
        И EL просматривает все эти контексты в следующем порядке:
    <ul>
        <li>Контекст страницы (pageContext)</li>
        <li>Контекст запроса (requestContext)</li>
        <li>Контекст сессии (sessionContext)</li>
        <li>Контекст приложения (applicationContext)</li>
    </ul>
    Соответственно, если контексты запроса и сессии содержат атрибут с одним и тем же именем,
    <br/>то будет использоваться атрибут из контекста запроса.
    <p>
        если выводить данные из какого-то определенного контекста:
        <br/> названием данных мы можем указать название контекста:
        <br/> pageScope, requestScope, sessionScope или applicationScope.
    </p>
    </p>
    <p>Second: ${usersList[0]}</p>
    <p>Second: ${users[1]}</p>
    <p>Third: ${users[2]}</p>
</div>
<div>
    По умолчанию Expression Language предоставляет ряд встроенных объектов, которые позволяют использовать различные
    аспекты запроса:
    <ul>
        <li>param: объект, который хранит все переданные странице параметры</li>
        <li>paramValues: хранит массив значений для определенного параметра (если для параметра передается сразу
            несколько значений)
        </li>
        <li>header: хранит все заголовки запроса</li>
        <li>headerValues: предоставляет массив значений для определенного заголовка запроса</li>
        <li>cookie: предоставляет доступ к отправленным в запросе кукам</li>
        <li>initParam: возвращает значение для определенного параметра из элемента context-param из файла web.xml</li>
        <li>pageContext: предоставляет доступ к объекту PageContext, представляет контекст текущей страницы jsp</li>
    </ul>
</div>
<h3>
    Получение параметров запроса: ?name=Sam&age=31
</h3>
<p>Name: ${param.name}</p>
<p>Age: ${param.age}</p>

<form action="postuser.jsp" method="post">
    Name: <input name="name"/>
    <br><br>
    Main Phone: <input name="phone"/>
    <br></br>
    Additional Phone: <input name="phone"/>
    <br></br>
    <input type="submit" value="Submit"/>
</form>

<h3>Получение куки</h3>
<p>From cookie: ${cookie.userName.value}</p>

<h3>Получение заголовков HTTP</h3>
<p>User-Agent: ${header["User-Agent"]}</p>
<p style="margin-left: 40px">Если название заголовка представляет сложное слово с дефисами, как "User-Agent",
    <br>то для получения его значения используется конструкция header["название_заголовка"]
</p>
<h4 style="margin-left: 100px">Cookie: $_{header["Cookie"]} = Cookie: $_{header.cookie}</h4>
<p>Cookie: ${header["Cookie"]}</p>
<p>Cookie: ${header.cookie}</p>
<p>Host: ${header.host}</p>

</body>
</html>

