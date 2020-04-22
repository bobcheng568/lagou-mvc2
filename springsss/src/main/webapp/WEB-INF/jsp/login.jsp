<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Insert title here</title>
</head>
<body>
<center>
    <h1>登录</h1>
    <form method="post" action="/login/auth">
        <table border="0">
            <tr>
                <td>账号：</td>
                <td><input id="username" type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input id="password" type="password" name="password">
                </td>
            </tr>
        </table>
        <br>
        <input type="submit" value="登录"/>
    </form>
</center>
</body>
</html>