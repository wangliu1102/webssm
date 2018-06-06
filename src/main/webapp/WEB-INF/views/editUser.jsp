<%--
  Created by IntelliJ IDEA.
  User: wl
  Date: 2017/4/7
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--允许使用EL表达式--%>
<%@page isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>编辑用户</title>
</head>
<body>
    <form action="updateUser" method="post">
        <input type="hidden" name="id" value="${user.id}">
        姓名：<input type="text" name="name" value="${user.name}"><br>
        出生日期：<input type="date" name="birthday" value="<fmt:formatDate value='${user.birthday}' pattern='yyyy-MM-dd' />"><br>
        薪水：<input type="text" name="salary" value="${user.salary}"><br>
        <input type="submit" value="编辑">
    </form>

</body>
</html>
