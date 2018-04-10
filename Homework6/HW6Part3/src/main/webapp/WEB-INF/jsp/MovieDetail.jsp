<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qiaoz
  Date: 2/20/2018
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>MovieDetail</title>
</head>
<body>
<p>You searched for ${sessionScope.keyword}</p>
<p>Here are the search results</p>
<c:forEach items="${sessionScope.movieList}" var="movie">
    <p>Movie Title: ${movie.title}</p>
    <p>Lead Actor: ${movie.actor}</p>
    <p>Lead Actress: ${movie.actress}</p>
    <p>Genre: ${movie.genre}</p>
    <p>Year: ${movie.year}</p>
</c:forEach>
<br/>
<a href="index.html">back to main page</a>
</body>
</html>
