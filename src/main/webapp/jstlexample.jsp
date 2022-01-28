<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <title>JSTL</title>
</head>
<body>

<h4>< p>$ {message}< /p></h4>
<p> тогда как с сервлета передается: < script>alert('Hello gold')< /script> </p>
<p>
    И если в jsp для вывода атрибута message применяется только стандартный EL:
    <br>
    то в результате этот html-код будет внедрен напрямую в страницу:
</p>
<h3>Защита от внедрения кода:</h3>
<p>${message}</p>
<p>Тег c:out позволяет декодировать теги html. Его атрибут value указывает на выводимое значение.
    <br>В итоге мы получим совсем другой вывод:
</p>
<p><c:out value="${message}"/></p>

<h3>Значение по умолчанию</h3>
<p>
    Через атрибуты сервлет передает данные в JSP.
    <br>Однако вполне возможно, что из-за каких-то условий нужное значение не будет передано.
    <br>В этом случае мы можем установить для тега c:out значение по умолчанию, используя его параметр default:
    <br><b>< p>< c : out value="$_{message2}" default="Hello world" />< /p></b>
</p>
<p><c:out value="${message2}" default="Hello world"/></p>

<h2>Основные возможности JSTL</h2>
<h3>Цикл</h3>
<br>В данном случае параметр "items" указывает на коллекцию, элементы которой выводятся.
<br>А параметр "var" задает переменную, через которую доступен текущий перебираемый элемент.
<ol>
<c:forEach var="user" items="${users}">
    <li>${user}</li>
</c:forEach>
</ol>

<ul>
    <c:forEach var="user" items="${users}">
        <li><c:out value="${user}" /></li>
    </c:forEach>
</ul>
<ul>
    <c:forEach var="cook" items="${cookie}">
        <li>
            <p><c:out value="${cook.value.name}" /></p>
            <p><c:out value="${cook.value.value}" /></p>
        </li>
    </c:forEach>
</ul>

<h3>Условные выражения</h3>
<br> Если надо задать альтернативную логику, то можно добавить тег c:if, который проверяет противоположное условие:
<c:if test="${isVisible == true}">
    <p>Visible</p>
</c:if>
<c:if test="${isVisible == false}">
    <p>Invisible</p>
</c:if>

<h3>Тег choose</h3>
<c:choose>
    <c:when test="${val == 1}">
        <p>Equals to 1</p>
    </c:when>
    <c:when test="${val == 2}">
        <p>Equals to 2</p>
    </c:when>
    <c:otherwise>
        <p>Undefined</p>
    </c:otherwise>
</c:choose>

<h3>Тег url</h3>
<a href='<c:url value="/index" />'><c:url value="/index" /></a>

<h3>Редирект </h3>
<c:if test="${val == null}">
    <c:redirect url="/notfound.jsp" />
</c:if>
</body>
</html>
