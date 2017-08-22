<%--
  User: 果占先
  Date: 2017/8/22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <title>这是标题</title>
</head>
<body>
    <table border="1" cellspacing="0" cellpadding="0" width="40%">
        <tr>
            <th>序号</th>
            <th>学号</th>
            <th>姓名</th>
            <th>年龄</th>
        </tr>
        <c:forEach var="sss" items="${requestScope.list}" varStatus="aaa">
            <tr>
                <td>${aaa.count}===${aaa.index}===${aaa.first}===${aaa.last}</td>
                <td>${sss.id}</td>
                <td>${sss.name}</td>
                <td>${sss.age}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
