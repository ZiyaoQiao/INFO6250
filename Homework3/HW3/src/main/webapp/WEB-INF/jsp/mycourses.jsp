<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course View</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <%--[<a href='searchCourse.jsp'>Go to Search page</a>] --%>
        <%--[<a href="login.do?action=logout">Logout</a>]--%>
        <h3> Courses Added:</h3>
        <!--if there are no course in the set-->
        <c:choose>
            <c:when test="${empty sessionScope.myCourseSet}">
                <div><p> No Course Added for you.</p></div>
            </c:when>
            <c:otherwise>
                <c:forEach items="${sessionScope.myCourseSet}" var="course">
                    <p>CRN: ${course.crn} - Course Name: ${course.name} [<a href='course.do?action=remove&crn=${course.crn}'>Remove Course</a>]</p>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>
</html>
