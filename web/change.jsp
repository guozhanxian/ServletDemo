<%--
  User: 果占先
  Date: 2017/8/21
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
    <fmt:bundle basename="com.ralph.res.message">
    <%
        request.setCharacterEncoding("utf-8");
        String msg = request.getParameter("msg");
        if(msg != null && msg.length()>0)
        {
    %>
    <h1><%=msg%></h1>
    <%
        }
    %>

    <c:choose>
        <c:when test="${param['code']=='200'}">
            <h1 style="color:green">${param["msg"]}</h1>
        </c:when>
        <c:otherwise>
            <h1 style="color:red">${param["msg"]}</h1>
        </c:otherwise>
    </c:choose>
    <form action="change.action" method="post">
        <fmt:message key="account1" /><input type="text" name="id1"><br>
        <fmt:message key="account2" /><input type="text" name="id2"><br>
        <fmt:message key="money" /><input type="text" name="money"><br>
        <input type="submit" value="<fmt:message key="changebtn" />">
    </form>
    </fmt:bundle>
</body>
</html>
