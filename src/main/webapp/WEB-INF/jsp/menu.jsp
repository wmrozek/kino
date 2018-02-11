<%@ page import="com.sda.kino.utils.SessionUtils" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    new SessionUtils().checkSession(request, response);
%>

<c:choose>
    <c:when test="${sessionScope.get('user') eq null}">
        <ul>
            <li><a href="./">Strona główna</a></li>
            <li><a href="./register">Rejestracja</a></li>
            <li><a href="./login">Logowanie</a></li>
        </ul>
    </c:when>
    <c:otherwise>
        <p>Witaj, ${sessionScope.get('user')}</p>
        <ul>
            <li><a href="./">Strona główna</a></li>
            <li><a href="./seances">Wyszukaj seans</a></li>
        </ul>
        <form action="/logout" method="post">
            <input type="submit" value="Wyloguj">
        </form>
    </c:otherwise>

</c:choose>


