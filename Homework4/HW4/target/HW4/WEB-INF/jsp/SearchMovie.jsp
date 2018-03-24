<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: qiaoz
  Date: 2/20/2018
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Movies</title>
</head>
<body>
<h1>Searching Movies</h1>
<form:form action="searchMovie.html">
    <div>
        KeyWord:
        <input name="keyword"/>
    </div>
    <input type="radio" name="searchBy" value="title">Search By Title<br/>
    <input type="radio" name="searchBy" value="actor">Search by Actor<br/>
    <input type="radio" name="searchBy" value="actress">Search by Actress<br/>
    <input type="submit" value="SearchMovies">
</form:form>
</body>
</html>
