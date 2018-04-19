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
<jsp:include page="include/header.jsp"/>

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
                    <input type="text" class="form-control" id="inputUserName" placeholder="username" readonly>
                </div>
            </div>
            <div class="form-group">
                <label for="inputEmail" class="col-sm-2 col-md-2 control-label">Email</label>
                <div class="col-sm-6 col-md-6">
                    <input type="email" class="form-control" id="inputEmail" placeholder="xxxxxx@xx.com" readonly>
                </div>
            </div>
            <div class="form-group">
                <label for="inputNickname" class="col-sm-2 col-md-2 control-label">Nickname</label>
                <div class="col-sm-6 col-md-6">
                    <input type="text" class="form-control" id="inputNickname" placeholder="nickname" />
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword" class="col-sm-2 col-md-2 control-label">Password</label>
                <div class="col-sm-6 col-md-6">
                    <input type="password" class="form-control" id="inputPassword" placeholder="password" />
                </div>
            </div>
            <div class="form-group">
                <label for="inputPhoneNumber" class="col-sm-2 col-md-2 control-label">Phone Number</label>
                <div class="col-sm-6 col-md-6">
                    <input type="text" class="form-control" id="inputPhoneNumber" placeholder="+1 xxxxxxxxxx" />
                </div>
            </div>
            <div class="form-group">
                <label for="man" class="col-sm-2 col-md-2 control-label">Gender</label>
                <div class="col-sm-6 col-md-6">
                    <label class="radio-inline">
                        <input type="radio" id="man" value="option1"> Male
                    </label>
                    <label class="radio-inline">
                        <input type="radio" id="woman" value="option2"> Female
                    </label>
                </div>
            </div>
            <div class="form-group">
                <label for="birthday" class="col-sm-2 col-md-2 control-label">Date of Birth</label>
                <div class="col-sm-6 col-md-6">
                    <input type="text" class="form-control" id="birthday" placeholder="18" />
                </div>
            </div>
            <div class="form-group">
                <label for="postcodes" class="col-sm-2 col-md-2 control-label">Postal Code</label>
                <div class="col-sm-6 col-md-6">
                    <input type="text" class="form-control" id="postcodes" placeholder="00000" />
                </div>
            </div>
            <div class="form-group">
                <label for="address" class="col-sm-2 col-md-2 control-label">Address</label>
                <div class="col-sm-6 col-md-6">
                    <input type="text" class="form-control" id="address" placeholder="Boston" />
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
<jsp:include page="include/foot.jsp"/>
<script type="text/javascript">
    initData();
    function initData() {
        var userId = ${currentUser.id};
        var user = getUserById(userId);
        var userDetail = getUserDetailById(userId);
        document.getElementById("inputUserName").value = user.name;
        document.getElementById("inputEmail").value = user.email;
        document.getElementById("inputNickname").value = user.nickName;
        document.getElementById("inputPassword").value = userDetail.password;
        document.getElementById("inputPhoneNumber").value = userDetail.phoneNumber;
        document.getElementById("birthday").value = userDetail.birthday;
        document.getElementById("postcodes").value = userDetail.postNumber;
        document.getElementById("address").value = userDetail.address;
        if(userDetail.sex == 0)
            document.getElementById("man").checked = true;
        else
            document.getElementById("woman").checked = true;
    }
    function startUpdate() {
        var loading = layer.load(0);
        var user = {};
        user.userName = document.getElementById("inputUserName").value;
        user.email = document.getElementById("inputEmail").value;
        user.nickName = document.getElementById("inputNickname").value;
        user.password = document.getElementById("inputPassword").value;
        user.phoneNumber = document.getElementById("inputPhoneNumber").value;
        user.birthday = document.getElementById("birthday").value;
        user.postNumber = document.getElementById("postcodes").value;
        user.address = document.getElementById("address").value;
        user.sex = 0;
        if(document.getElementById("woman").checked)
            user.sex = 1;
        if(user.userName == ''){
            layer.msg('Username can not be empty',{icon:2});
            return;
        }
        else if(user.userName.length >= 12){
            layer.msg('Username can not exceed 12 characters',{icon:2});
            return;
        }
        if(user.nickName == ''){
            layer.msg('Nick name can not be empty',{icon:2});
            return;
        }
        else if(user.nickName.length >= 15){
            layer.msg('Nick name can not exceed 15 characters',{icon:2});
            return;
        }
        else if(user.password == ''){
            layer.msg('Password can not be empty',{icon:2});
            return;
        }
        else if(user.password.length>= 20){
            layer.msg('Password can not exceed 20 characters',{icon:2});
            return;
        }
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

    function getUserById(id) {
        var userResult = "";
        var user = {};
        user.id = id;
        $.ajax({
            async : false, //设置同步
            type : 'POST',
            url : '${cp}/getUserById',
            data : user,
            dataType : 'json',
            success : function(result) {
                userResult = result.result;
            },
            error : function(result) {
                layer.alert('Search Error');
            }
        });
        userResult = JSON.parse(userResult);
        return userResult;
    }

    function getUserDetailById(id) {
        var userDetailResult = "";
        var user = {};
        user.id = id;
        $.ajax({
            async : false, //设置同步
            type : 'POST',
            url : '${cp}/getUserDetailById',
            data : user,
            dataType : 'json',
            success : function(result) {
                userDetailResult = result.result;
            },
            error : function(result) {
                layer.alert('Search Error');
            }
        });
        userDetailResult = JSON.parse(userDetailResult);
        return userDetailResult;
    }
</script>
</body>
</html>