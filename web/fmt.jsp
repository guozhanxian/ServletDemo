<%@ page import="java.util.Date" %><%--
  User: 果占先
  Date: 2017/8/22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <title>这是标题</title>
</head>
<body>
    <c:set var="now" value="<%=new Date()%>" />
    <fmt:formatDate value="${now}" type="time" /><br>
    <fmt:formatDate value="${now}" type="date" /><br>
    <fmt:formatDate value="${now}" type="both" /><br>
    <fmt:formatDate value="${now}" type="both" dateStyle="short" timeStyle="short" /><br>
    <fmt:formatDate value="${now}" type="both" dateStyle="medium" timeStyle="medium" /><br>
    <fmt:formatDate value="${now}" type="both" dateStyle="long" timeStyle="long" /><br>
    <fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" /><br>

    <c:set var="balance" value="120000.2309" />
    <fmt:formatNumber value="${balance}" type="currency" /><br>
</body>
</html>
