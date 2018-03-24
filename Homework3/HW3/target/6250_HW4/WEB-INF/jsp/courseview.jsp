<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Available Courses are:</title>
    </head>
    <body>
        <form method='post' action='course.do'>
            <h2> Results found </h2>
            <c:forEach var="course" items="${sessionScope.searchResults}">
                <input type="checkbox" name="crn" value="${course.crn}" />${course} [<a href="course.do?action=add&crn=${course.crn}">Add Course</a>]<br/>
            </c:forEach>
            <input type='hidden' name='action' value='add'/>
            <input type='submit' value='Add selected courses'>
        </form>
    </body>
</html>
