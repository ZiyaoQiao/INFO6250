<%--
  Created by IntelliJ IDEA.
  User: qiaoz
  Date: 3/25/2018
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="j_security_check" method="post">
    <table>
        <tr>
            <td>User name: <input type="text" name="j_username"></td>

        </tr>
        <tr>
            <td>Password: <input type="password" name="j_password"></td>
        </tr>
        <tr>
            <th><input type="submit" value="Log In"></th>
        </tr>
    </table>
</form>
</body>
</html>
