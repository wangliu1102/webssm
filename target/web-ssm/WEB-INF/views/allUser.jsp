<%@ page import="java.util.ArrayList" %>
<%@ page import="com.web.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: wl
  Date: 2017/4/7
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <h3><a href="/user/toAddUser">添加用户</a></h3>
    <table border="1">
        <tbody>
            <tr>
                <th>编号</th>
                <th>姓名</th>
                <th>出生日期</th>
                <th>薪水</th>
                <th>操作</th>
            </tr>
            <c:if test="${!empty userList}">
                <c:forEach items="${ userList }" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td><fmt:formatDate value='${user.birthday}' pattern='yyyy-MM-dd' /></td>
                        <%--<td>${user.birthday}</td>--%>
                        <td>${user.salary}</td>
                        <td>
                            <a href="/user/getUser?id=${user.id}">编辑</a>
                            <a href="/user/deleteUser?id=${user.id}">删除</a>
                        </td>

                    </tr>
                </c:forEach>
            </c:if>
        </tbody>
    </table>
</body>
</html>
