<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
    <script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
    <script>
        /**
         * 分析：
         * 1.点击超链接或者图片，需要换一张
         * 2.重新设置图片的src属性值
         *
         */
        window.onload=function (ev) {
            //1.获取图片对象
            var img = document.getElementById("checkCode");
            //2.绑定单击事件
            img.onclick=function (ev1) {
                //加时间戳
                var date=new Date().getTime();
                img.src="/ITJEE/checkCodeServlet?"+date;
            }
            //1.获取超链接
            var sura=document.getElementById("change");
            //2.绑定单击事件
            sura.onclick=function (ev1) {
                var date=new Date().getTime();
                img.src="/ITJEE/checkCodeServlet?"+date;
            }
        }
    </script>
</head>

<body>

<div class="container">

    <form class="form-signin" action="${pageContext.request.contextPath}/loginServlet" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>

        <label for="username" class="sr-only">Username</label>
        <input name="username" type="text" id="username" class="form-control" placeholder="Username" required autofocus>

        <label for="password" class="sr-only">Password</label>
        <input name="password" type="password" id="password" class="form-control" placeholder="Password" required>

        <img aria-colspan="2" id="checkCode" src="/ITJEE/checkCodeServlet">
        <a id="change" href="">看不清换一张？</a>
        <input name="checkCode" type="text" >
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>

</div> <!-- /container -->

${requestScope.checkCode_error}
${requestScope.Login_error}

</body>
</html>