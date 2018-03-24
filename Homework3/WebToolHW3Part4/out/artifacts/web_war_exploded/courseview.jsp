<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:directive.page import="Course"></jsp:directive.page>
<jsp:directive.page import="java.util.ArrayList"></jsp:directive.page>
<!DOCTYPE html>
<html>
    <head>
        <title>Available Courses are:</title>
    </head>
    <body>
        <form method='post' action='course.do'>
            <h2> Results found </h2>
            <c:forEach var="course" items="${pageContext.request.searchResults}">
                <c:set var="crn" value="course.crn" />
                <c:set var="courseName" value="course.name"/>
                <c:set var="description" value="course.courseDescription" />
                <c:set var="instructor" value="course.instructor" />
                <input type="checkbox" name="crn" value="${crn}">${crn} - ${courseName} [<a href='course.do?action=add&crn=" + ${crn} + "'>Add Course</a>]<br/>
            </c:forEach>
            <input type='hidden' name='action' value='add'/>
            <input type='submit' value='Add selected courses'>
        </form>
    </body>
</html>
