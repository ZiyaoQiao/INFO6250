<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qiaoz
  Date: 2018/4/14
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body style="margin: 0px;border: 0px; padding: 0px;">
<div style="background-color: #555555;" >
    <div>
        BlackBoard - ${user.name} - <a href="logout.html">Logout</a>
    </div>
    <div style="float: right;">
        <a href="mainAction.html?action=Home" id="Home">Home</a>
        <a href="mainAction.html?action=Courses" id="Courses">Courses</a>
        <a href="mainAction.html?action=Community" id="Community">Community</a>
        <a href="mainAction.html?action=ContentCollection" id="ContentCollection">Content Collection</a>
        <a href="mainAction.html?action=MyPage" id="MyPage">My Page</a>
        <a href="mainAction.html?action=Training" id="Training">Training</a>
        <a href="mainAction.html?action=SupportServices" id="SupportServices">Support & Services</a>
        <script>
            document.getElementById(${sessionScope.currentPage}).style.font.bold;
        </script>
    </div>
</div>
</body>
</html>
