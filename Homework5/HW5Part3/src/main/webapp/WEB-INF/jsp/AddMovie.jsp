<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: qiaoz
  Date: 2/20/2018
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Movie</title>
</head>
<body>
<h1>Please enter the details below:</h1>
<form action="addMovie.html">
    <div>
        Movie Title:
        <input name="title" type="text" required="required"/>
    </div>
    <div>
        Lead Actor:
        <input name="actor" type="text" required="required"/>
    </div>
    <div>
        Lead Actress:
        <input name="actress" type="text" required="required"/>
    </div>
    <div>
        Genre:
        <input name="genre" type="text" required="required"/>
    </div>
    <div>
        Year:
        <input name="year" type="number" required="required"/>
    </div>
    <input type="submit" value="Movie"/>
</form>
</body>
</html>
