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
<form:form action="addMovie.html" commandName='add'>
    <div>
        Movie Title:
        <form:input path="title"/>
    </div>
    <div>
        Lead Actor:
        <form:input path="actor"/>
    </div>
    <div>
        Lead Actress:
        <form:input path="actress"/>
    </div>
    <div>
        Genre:
        <form:input path="genre"/>
    </div>
    <div>
        Year:
        <form:input path="year"/>
    </div>
    <input type="submit" value="Movie"/>
</form:form>
</body>
</html>
