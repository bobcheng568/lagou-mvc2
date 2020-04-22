<%@ page import="com.lagou.edu.pojo.Resume" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" isELIgnored="false" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Insert title here</title>
</head>
<body>
<center>
    <div>
        <a href="/resume/toSave">新增</a>
    </div>
    <table>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>地址</th>
            <th>电话</th>
            <th>操作</th>
        </tr>
        <%
            if (request.getAttribute("resumes") != null) {
        %>
        <%for (Resume u : (List<Resume>) request.getAttribute("resumes")) {%>
        <tr>
            <td><%=u.getId()%>
            </td>
            <td><%=u.getName()%>
            </td>
            <td><%=u.getAddress()%>
            </td>
            <td><%=u.getPhone()%>
            </td>
            <td>
                <a href="/resume/queryById?id=<%=u.getId()%>">修改</a>
                <a href="/resume/delete?id=<%=u.getId()%>">删除</a>
            </td>
        </tr>
        <%}%>
        <%}%>
    </table>
</center>

</body>
</html>