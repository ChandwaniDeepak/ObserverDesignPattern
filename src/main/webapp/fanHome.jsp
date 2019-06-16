<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>

    <a href="/fanLogout">Logout</a>
    <hr>

    <form action="/follow" method="post">
        <select name="celeb">
            <c:forEach items="${celebs}" var="celeb">
                <option value="${celeb.fName}${celeb.lName}">${celeb.fName} ${celeb.lName}</option>
            </c:forEach>
        </select>

        <input type="submit" value="Follow">
    </form>

    <c:if test="${following}">
        <p>Now you are following ${name}</p>
    </c:if>




</body>
</html>