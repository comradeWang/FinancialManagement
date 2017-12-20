<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>金融管理·登录</title>
    <link rel="stylesheet" href="${ctx}/common/css/foundation.css">
    <link rel="stylesheet" href="${ctx}/page/login/css/login.css">
    <link rel="stylesheet" href="${ctx}/common/css/unlock.css">
    <link rel="shortcut icon" href="${ctx}/favicon.ico">

</head>
<body>

    <div class="grid-x" style="height: 100%">
        <div class="cell small-6"></div>
        <div class="cell small-6" style="position: relative">
            <div class="login_panel">
            <div class="login_logo"></div>
            <div class="login_form">
                <form>
                    <label for="login_userName">用户名：
                        <input type="text" placeholder="请输入您的用户名" id="login_userName">
                    </label>
                    <label for="login_userName">密码：
                        <input type="text" placeholder="请输入您的用户名" id="login_password">
                    </label>
                    <div id="vertify" style="height: 40px ;width: 100%"></div>
                </form>
                <a type="button" class=" button expanded login_btn" >登录</a>
                <a type="button" class=" button hollow expanded register_btn" href="${ctx}/register/register" >注册</a>
            </div>
        </div>
        </div>
    </div>


</body>
<script src="${ctx}/common/js/jquery-3.2.1.min.js"></script>
<script src="${ctx}/common/js/foundation.js"></script>
<script src="${ctx}/common/js/unlock.js"></script>
<script>
    $(function () {
        var $container = $('#vertify');
        $container.slideToUnlock({
            text : '滑动以验证',
            succText : '验证成功',
            successFunc:function () {
                alert('you are nothing!!');
            }
        });
        $(window).resize(function () {
            $('.slide-to-unlock-bg').width($container.width());
        });
        sessionStorage.setItem("register","${ctx}/page/")
    })
</script>
</html>