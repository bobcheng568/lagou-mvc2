<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Insert title here</title>
</head>
<body>
<center>
    <h1>登录</h1>
    <form method="post" action="/resume/save">
        <table border="0">
            <tr>
                <td>姓名：</td>
                <td><input type="text" name="name" value="${resume.name}"></td>
            </tr>
            <tr>
                <td>地址：</td>
                <td><input type="text" name="address" value="${resume.address}">
                </td>
            </tr>
            <tr>
                <td>电话：</td>
                <td><input type="text" name="phone" value="${resume.phone}">
                </td>
            </tr>
        </table>
        <input name="id" type="hidden" value="${resume.id}"/>
        <br>
        <input type="submit" value="保存"/>
    </form>
</center>
</body>
</html>