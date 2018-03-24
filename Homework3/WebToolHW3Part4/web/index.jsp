<!--By default this is true-->
<!--Even if this line is removed, by default the session will continue.-->
<!--Session is an implicit object in JSP-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <title>NEU Courses</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
    </head>
    <body>
        <div>
            <h1>Login</h1>
            <c:forEach items="${pageContext.request.cookies}" var="cookies">
            <c:if test="${fn:contains(cookies.name,'username')}">
                <c:set var="username" value="${cookies.value}"/>
            </c:if>
            <c:if test="${fn:contains(cookies.name,'password')}">
                <c:set var="password" value="${cookies.value}"/>
            </c:if>
            </c:forEach>
            <c:if test="${password eq 'admin' &&username eq 'admin'}">
                <c:redirect url="searchCourse.jsp" />
            </c:if>
            <c:if test="${empty pageContext.session}">
                <c:redirect url="searchCourse.jsp" />
            </c:if>
            <form name='myForm' method="post" action="login.do?action=login">
                <input type="text" name="username" placeholder="Username" /><br/><br/>
                <input type="password" name="password" placeholder="Password"  /><br/><br/>                
                <input type="checkbox" name="rememberMe" value="remember" /> Remember me  <br/><br/>
                <input type="submit" value="Log In" />
            </form>
        </div>
    </body>
</html>
