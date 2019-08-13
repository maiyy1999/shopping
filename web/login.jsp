<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style type="text/css">
        body {
            background-image: url("./img/b.jpg");
            color: #555;
        }

        .login-box {
            width: 450px;
            margin: 0 auto;
            margin-top: 150px;
            background-color: rgba(135,135,135,0.29);
            padding: 20px;
            border-radius: 5px;
            box-shadow: 2px 2px 5px #ccc;
        }

        .login-title {
            text-align: center;
        }

        .login-row {
            padding: 10px 0px 10px 0px;
        }

        .login-text {
            width: 80%;
            border: 1px solid #ccc;
            height: 30px;
            padding-left: 10px;
        }
    </style>
</head>
<body>
<div class="login-box">
    <h1 class="login-title">欢迎登录</h1>
    <form action="/login" method="post">
        <div class="login-row">
            账号：<input type="text" class="login-text" name="username" />
        </div>
        <div class="login-row">
            密码：<input type="password" class="login-text" name="password" />
        </div>
        <div class="login-row">
            <button type="submit">登录</button>
        </div>
    </form>
</div>
</body>
</html>
