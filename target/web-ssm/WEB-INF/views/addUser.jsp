<%--
  Created by IntelliJ IDEA.
  User: wl
  Date: 2017/4/7
  Time: 16:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>添加用户</title>
</head>
<body>
    <h1>添加用户</h1>
    <form action="addUser" method="post">
        姓名：<input type="text" name="name"><br>
        出生日期：<input type="date" name="birthday"><br>
        薪水：<input type="text" name="salary"><br>
        <input type="submit" value="添加">
    </form>
</body>
</html>
