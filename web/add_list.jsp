<%--
  Created by IntelliJ IDEA.
  User: myy
  Date: 2019/8/12
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增商品页面</title>
</head>
<body>
<form action="insertServlet" method="post">
    <table>
        <tr>
            <td> gname</td>
            <td><input type="text" name="gname"/></td>
        </tr>
        <tr>
            <td> picture</td>
            <td><input type="file" id="file" name="picture"/></td>
        </tr>
        <tr>
            <td> price</td>
            <td><input type="text" name="price"/></td>
        </tr>
        <tr>
            <td>description</td>
            <td><input type="text" name="description"/></td>
        </tr>
        <tr>
            <td>stock</td>
            <td><input type="text" name="stock"/></td>
        </tr>
        <tr>
            <td>flag</td>
            <td><input type="text" name="flag"/></td>
        </tr>
        <tr>
            <td>created</td>
            <td><input type="text" name="created"/></td>
        </tr>
        <tr>

            <td colspan="2" ><input type="submit" value="提交"></td>
        </tr>


    </table>

</form>
</body>
</html>
