<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div{


            padding-top: 100px;
           margin: 0 auto;
        }
        table{
            width: 40%;
            height: 55%;
        }

    </style>
</head>
<body>
<div>
        <table border="1px"  align="center" >
            <c:if test="${list!=null&&list.size()>0}">
                <c:forEach items="${list}" var="goods" varStatus="cc">
                    <tr>
                        <td>商品号</td>
                        <td><input type="text" value="${goods.id}"/></td>
                    </tr>
                    <tr>
                        <td>商品的名字</td>
                        <td><input type="text" value="${goods.gname}"/></td>
                    </tr>
                    <tr>
                        <td>图片</td>
                        <td><img src="./img/${goods.picture}"width="80px" height="80px"></td>
                    </tr>
                    <tr>
                        <td>价格</td>
                        <td><input type="text" value="${goods.price}"/></td>
                    </tr>
                    <tr>
                        <td>描述</td>
                        <td><input type="text" value="${goods.description}"/></td>
                    </tr>
                    <tr>
                        <td>库存量</td>
                        <td><input type="text" value="${goods.stock}"/></td>
                    </tr>
                    <tr>
                        <td>状态</td>
                        <td><input type="text" value="${goods.flag}"/></td>
                    </tr>
                    <tr>
                        <td>创建者</td>
                        <td><input type="text" value="${goods.created}"/></td>
                    </tr>
                    <tr>
                        <td>创建时间</td>
                        <td><input type="text" value="${goods.createDate}"/></td>
                    </tr>

                </c:forEach>

            </c:if>
        </table>

</div>
</body>

</html>
