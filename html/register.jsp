<%--
  Created by IntelliJ IDEA.
  User: Avenger
  Date: 2017/12/20 0020
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>金融管理·注册</title>
    <link rel="stylesheet" href="${ctx}/ui_components/foundation/css/foundation.css">
    <link rel="stylesheet" href="${ctx}/css/login/register.css">
    <link rel="stylesheet" href="${ctx}/ui_components/unlock/css/unlock.css">
    <link rel="shortcut icon" href="${ctx}/favicon.ico">
</head>
<body>
    <div class="register-panel">
        <div class="register-title text-center">用户注册</div>
        <div class="register-form">
            <form>
                <label for="register_userName">用户名：
                <input type="text"  transmit="true" placeholder="请输入您的用户名" id="register_userName" name="register_userName">
                </label>
                <label for="register_userName">真实姓名：
                    <input type="text"  transmit="true" placeholder="请输入您的真实姓名" maxlength="4" id="register_realName" name="register_realName">
                </label>
                <label>性别
                    <select>
                        <option value="1">男</option>
                        <option value="2">女</option>
                    </select>
                </label>
                <label for="register_password">密码：
                    <input type="text" transmit="true" placeholder="请输入您的密码" maxlength="15" id="register_password" name="register_password">
                </label>
                <label for="ensure_register_password">确认密码：
                    <input type="text" transmit="true" placeholder="请输入您的密码" maxlength="15" id="ensure_register_password" name="ensure_register_password">
                </label>
            </form>
        </div>
        <div class="register-btn-container">
            <div class="grid-x">
                <div class="small-6 cell">
                    <a class="button primary" onclick="register()">注册</a>
                </div>
                <div class="small-6 cell">
                    <a class="button secondary" href="#">返回登录</a>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="${ctx}/js/jquery-3.2.1.min.js"></script>
<script src="${ctx}/ui_components/foundation/js/foundation.js"></script>
<script src="${ctx}/ui_components/unlock/js/unlock.js"></script>
<script src="${ctx}/js/login/register.js"></script>
</html>
