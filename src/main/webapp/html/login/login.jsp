<%--
  Created by IntelliJ IDEA.
  User: Avenger
  Date: 2017/12/20 0020
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>金融管理·登录</title>
    <link rel="stylesheet" href="/ui_components/foundation/css/foundation.css">
    <link rel="stylesheet" href="/css/login/login.css">
    <link rel="stylesheet" href="/ui_components/unlock/css/unlock.css">
    <link rel="shortcut icon" href="/favicon.ico">

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
<script src="/js/jquery-3.2.1.min.js"></script>
<script src="/ui_components/foundation/js/foundation.js"></script>
<script src="/ui_components/unlock/js/unlock.js"></script>
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
    })
</script>
</html>