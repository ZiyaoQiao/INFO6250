<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: qiaoz
  Date: 1/30/2018
  Time: 19:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All headers</title>
</head>
<body>
<%
    Enumeration names = request.getHeaderNames();
    Enumeration headers;
    while(names.hasMoreElements()){
        String tmp = (String)names.nextElement();
        headers = request.getHeaders(tmp);
        %>
<p><%out.println(tmp);%></p>
<%
        while(headers.hasMoreElements()){
            String str = (String)headers.nextElement();
            %>
<p><%
    out.println(str);%></p>
<%
        }
    }
%>
</body>
</html>
