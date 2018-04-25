<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cp" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Shopping Cart</title>
    <link href="${cp}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${cp}/css/style.css" rel="stylesheet">

    <script src="${cp}/js/jquery.min.js" type="text/javascript"></script>
    <script src="${cp}/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${cp}/js/layer.js" type="text/javascript"></script>
    <!--[if lt IE 9]>
    <script src="${cp}/js/html5shiv.min.js"></script>
    <script src="${cp}/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<!--导航栏部分-->
<jsp:include page="../include/header.jsp"/>

<!-- 中间内容 -->
<div class="container-fluid">
    <h1 class="title center">Edit Personal Information</h1>
    <br/>
    <div class="col-sm-offset-2 col-md-offest-2">
        <!-- 表单输入 -->
        <div  class="form-horizontal">
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 col-md-2 control-label">Username</label>
                <div class="col-sm-6 col-md-6">
                    <input type="text" class="form-control" id="inputUserName" placeholder="${sessionScope.currentUserDetail.name}" readonly>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 col-md-2 control-label">Email</label>
                <div class="col-sm-6 col-md-6">
                    <input type="email" class="form-control" id="inputEmail" placeholder="${sessionScope.currentUserDetail.email}" readonly>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 col-md-2 control-label">Password</label>
                <div class="col-sm-6 col-md-6">
                    <input type="password" class="form-control" id="inputPassword" placeholder="********" />
                </div>
            </div>
            <div class="form-group">
                <label for="inputPhoneNumber" class="col-sm-2 col-md-2 control-label">Phone Number</label>
                <div class="col-sm-6 col-md-6">
                    <input type="text" class="form-control" id="inputPhoneNumber" placeholder="${sessionScope.currentUserDetail.phoneNumber}" />
                </div>
            </div>
            <div class="form-group">
                <label for="address" class="col-sm-2 col-md-2 control-label">Address</label>
                <div class="col-sm-6 col-md-6">
                    <input type="text" class="form-control" id="address" placeholder="${sessionScope.currentUserDetail.address}" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-6">
                    <button class="btn btn-lg btn-primary btn-block" type="submit" onclick="startUpdate()">Confirm</button>
                </div>
            </div>
        </div>
        <br/>
    </div>
</div>

<!--尾部-->
<jsp:include page="../include/foot.jsp"/>
<script type="text/javascript">
    function startUpdate() {
        var loading = layer.load(0);
        var user = {};
        user.userName = document.getElementById("inputUserName").value;
        user.email = document.getElementById("inputEmail").value;
        user.password = document.getElementById("inputPassword").value;
        user.phoneNumber = document.getElementById("inputPhoneNumber").value;
        user.address = document.getElementById("address").value;

        var registerResult = null;
        $.ajax({
            async : false, //设置同步
            type : 'POST',
            url : '${cp}/doUpdate',
            data : user,
            dataType : 'json',
            success : function(result) {
                registerResult = result.result;
            },
            error : function(result) {
                layer.alert('Search User failed');
            }
        });
        if(registerResult == 'success'){
            layer.close(loading);
            layer.msg('Modified successfully',{icon:1});
            window.location.href="${cp}/main";
        }
        else if(registerResult == 'fail'){
            layer.msg('Server Error',{icon:2});
        }
    }
</script>
</body>
</html>