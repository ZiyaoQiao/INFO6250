<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: qiaoz
  Date: 2/12/2018
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<form action="removeCart.act">
    <c:forEach items="${sessionScope.cart}" var="items">
        <p><input type="checkbox" name="remove" value="${items}"> ${items} </p>
    </c:forEach>
    <input type="submit" value="remove" />
</form>
    <br/>
    <input type="button" value="Books" onclick="location.href='Books.act'" /><br/>
    <input type="button" value="Music" onclick="location.href='Music.act'" /><br/>
    <input type="button" value="Computers" onclick="location.href='Computers.act'" /><br/>
</body>
</html>
