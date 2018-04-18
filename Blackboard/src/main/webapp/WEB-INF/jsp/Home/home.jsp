<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: qiaoz
  Date: 4/10/2018
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<jsp:include page="../banner.jsp"/>
<div>
    Announcement
    <div>
        <c:choose>
            <c:when test="${sessionScope.announcementList.size eq 0}">
                <p>
                    No course or Organization Announcements have been posted in the last 7days.
                </p>
            </c:when>
            <c:otherwise>
                <c:forEach items="${sessionScope.announcementList}" var="announcement">
                    <a href="announcementDetail.html?announcement=${announcement}">${announcement}</a>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div>
    My Courses
    <div>
        <c:choose>
            <c:when test="${sessionScope.courseList.size eq 0}">
                <p>
                    No course registered.
                </p>
            </c:when>
            <c:otherwise>
                <c:forEach items="${sessionScope.courseList}" var="course">
                    <a href="courseDetail.html?course=${course}">${course}</a>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<div>
    Quick Tools
    <div>
        <table>
            <tr>
                <td><a href="announcementDetail.html?announcement=all">Announcement</a></td>
                <td><a href="myGrade.html">My Grades</a></td>
                <td><a href="personalInformation.html">Personal Information</a></td>
                <td><a href="tasks.html">Tasks</a></td>
                <td><a href="contactInformation.html">Contact Information</a></td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
