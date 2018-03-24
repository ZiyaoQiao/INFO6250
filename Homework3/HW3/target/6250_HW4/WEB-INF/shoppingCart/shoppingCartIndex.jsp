<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Shopping Cart</title>
        <script type="text/javascript">
            function switchPage(link) {
                document.getElementById("myFrame").src=link;
            }
        </script>
    </head>
    <body>
    <div style="width:20%;height: 100%;float: left">
        <a onclick="switchPage('Books.act')">Books</a><br/>
        <a onclick="switchPage('Music.act')">Music</a><br/>
        <a onclick="switchPage('Computers.act')">Computers</a><br/>
    </div>
    <div style="width:79%;height: 100%;float: right">
        <iframe id="myFrame" src="Books.act" frameborder="0" style="height: 100%; width:100%"></iframe>
    </div>
  </body>
</html>