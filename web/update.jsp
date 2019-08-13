<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="updateServlet" method="post">
        <table>
            <c:if test="${list!=null&&list.size()>0}">
            <c:forEach items="${list}" var="goods" varStatus="cc">
            <tr>
                <td><input type="hidden" name="id" value="${goods.id}"/></td>
            </tr>
            <tr>
                <td>新商品的名字</td>
                <td><input type="text" name="gname" value="${goods.gname}"/></td>
            </tr>
            <tr>
                <td>新的图片路径</td>
                <td><input type="text" name="picture" value="${goods.picture}"/></td>
            </tr>
            <tr>
                <td>输入新的价格</td>
                <td><input type="text" name="price" value="${goods.price}"/></td>
            </tr>
            <tr>
                <td>新的描述</td>
                <td><input type="text" name="description" value="${goods.description}"/></td>
            </tr>
            <tr>
                <td>新的库存量</td>
                <td><input type="text" name="stock" value="${goods.stock}"/></td>
            </tr>
            <tr>
                <td>新的状态</td>
                <td><input type="text" name="flag" value="${goods.flag}"/></td>
            </tr>
            <tr>
                <td>新的更改者的名字</td>
                <td><input type="text" name="created" value="${goods.created}"/></td>
            </tr>
            <tr>
                <td>更改时间:输入任一字符</td>
                <td><input type="date" name="createDate" value="${goods.createDate}"/></td>
            </tr>
                <tr>
                    <td><input type="submit" value="提交"></td>
                </tr>

            </c:forEach>

            </c:if>
                </table>
    </form>
</div>
</body>

</html>
