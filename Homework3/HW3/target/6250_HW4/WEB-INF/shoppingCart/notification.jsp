<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: qiaoz
  Date: 2/12/2018
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>notification</title>
</head>
<body>
    <c:choose>
        <c:when test="${empty sessionScope.list}">
            <div><p>Empty!</p></div>
        </c:when>
        <c:otherwise>
            <p>Successfully Added to Cart</p>
            <c:forEach items="${sessionScope.list}" var="str">
                <p>${str}</p>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    <br/>
    <input type="button" value="Books" onclick="location.href='Books.act'" /><br/>
    <input type="button" value="Music" onclick="location.href='Music.act'" /><br/>
    <input type="button" value="Computers" onclick="location.href='Computers.act'" /><br/>
</body>
</html>
