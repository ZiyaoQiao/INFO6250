<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qiaoz
  Date: 2/21/2018
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>addBook</title>
</head>
<body>
<form action="addBook.html">
    <table border="1">
        <tr>
            <th>ISBN</th>
            <th>Book Title</th>
            <th>Authors</th>
            <th>Price</th>
        </tr>
        <c:forEach var="count" begin="1" end="${sessionScope.num}">
            <tr>
                <td>
                    <input name="isbn" type="text" required="required"/>
                </td>
                <td>
                    <input name="title" type="text" required="required"/>
                </td>
                <td>
                    <input name="authors" type="text" required="required"/>
                </td>
                <td>
                    <input name="price" type="number" required="required"/>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Submit" />
</form>
</body>
</html>
