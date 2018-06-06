<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>主页</title>
    <style type="text/css">
        td{text-align: center;}
        .td2{text-align: right;}
        .table1{
            border:1px solid #ddd;
            width:900px;
        }
        thead{
            background-color:lightblue;
        }
    </style>
</head>
<body>

<h3><a href="/user/toAddUser">添加用户</a></h3>

<c:if test="${empty requestScope.pagemsg}">
    没有任何用户信息！
</c:if>
<c:if test="${!empty requestScope.pagemsg}">
    <table border="1" cellpadding="10" cellspacing="0" class="table1">
        <thead>
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>出生日期</th>
            <th>薪水</th>
            <th>操作</th>
        </tr>
        </thead>
        <c:forEach items="${requestScope.pagemsg.lists}" var="user">
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
    </table>
</c:if>

<table  border="0" cellspacing="0" cellpadding="0"  width="900px">
    <tr>
        <td class="td2">
            <span>第${requestScope.pagemsg.currPage }/ ${requestScope.pagemsg.totalPage}页</span>&nbsp;&nbsp;
            <span>总记录数：${requestScope.pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
            <span>
       <c:if test="${requestScope.pagemsg.currPage != 1}">
           <a href="/user/getPageUser?currentPage=1">[首页]</a>&nbsp;&nbsp;
           <a href="/user/getPageUser?currentPage=${requestScope.pagemsg.currPage-1}">[上一页]</a>&nbsp;&nbsp;
       </c:if>

       <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
           <a href="/user/getPageUser?currentPage=${requestScope.pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;
           <a href="/user/getPageUser?currentPage=${requestScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
       </c:if>
   </span>
        </td>
    </tr>
</table>
</body>
</html>