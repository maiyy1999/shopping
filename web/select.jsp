
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> 查询页面</title>
    <style>
        div{
            height: 200px;
            width: 350px;
            border: solid 1px chocolate;
            background-color:blanchedalmond;
            margin: 0 auto;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 2px 2px 5px #ccc;

        }
        a{

        }



    </style>
</head>
<body >
<div>
<form action="selectServlet" method="post">
<table>
    <caption align="center" >根据下列信息查询商品</caption>
        <tr>
            <td>商品号</td>
            <td><input type="text" name="id"/></td>
        </tr>
        <tr>
            <td> 商品名字</td>
            <td> <input type="text" name="gname"/></td>
        </tr>
        <tr>
            <td> 商品价格</td>
            <td> <input type="text" name="price"/></td>
        </tr>
        <tr>
            <td>商品描述</td>
            <td> <input type="text" name="description"/></td>
        </tr>
         <tr>
            <td>创建人</td>
            <td> <input type="text" name="created"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="提交"></td>
            <td><a href="add_list.jsp">create new customer</a></td>
        </tr>

</table>



</form>
</div>
</body >
</html>
