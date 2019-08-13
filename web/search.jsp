<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{
            margin: 0 auto;
            padding: 200px;

        }
        table{
             : center
        }

        tr {
           background-color:  aqua;
        }
        td{
            height: 20px;
        }


    </style>
</head>
<body>
<div>
<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>商品号</th>
        <th>商品名字</th>
        <th>图片</th>
        <th>价格</th>
<%--        <th>描述</th>--%>
<%--        <th>库存</th>--%>
<%--        <th>状态</th>--%>
<%--        <th>创建人</th>--%>
<%--        <th>创建时间</th>--%>
        <th>操作</th>
    </tr>
    <%--    //判断集合是否存在并且是否为空--%>
    <c:if test="${list!=null&&list.size()>0}">
        <c:forEach items="${list}" var="good" varStatus="s">
            <tr>
                <td>${good.id}</td>
                <td>${good.gname}</td>
                <td><img src="./img/${good.picture}"width="80px" height="80px"></td>
                <td>${good.price}</td>
<%--                <td>${good.description}</td>--%>
<%--                <td>${good.stock}</td>--%>
<%--                <td>${good.flag}</td>--%>
<%--                <td>${good.created}</td>--%>
<%--                <td>${good.createDate}</td>--%>

                <td><a href="deleteServlet?id=${good.id}" onclick="return confirm('确定删除吗?')">删除</a>|&nbsp;
                    <a href="updateServlet?id=${good.id}">更新</a>
                    <a href="selectServlet?id=${good.id}">详情</a>
                </td>

            </tr>
        </c:forEach>

    </c:if>
</table>
</div>
</body>
</html>q
