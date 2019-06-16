<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

    <a href="/celebLogout">Logout</a>
    <hr>
    <c:forEach items="${celeb.messages}" var="msg">
        <p>${msg}</p>
    </c:forEach>

    <form action="/newMessage"  method="post">
        <input type="text" name="msg">
        <input type="submit" value="Post Message">
    </form>


</body>
</html>