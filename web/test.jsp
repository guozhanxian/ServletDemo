<%@ page import="com.ralph.domain.Page" %><%--
  User: 果占先
  Date: 2017/8/21
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <title>这是标题</title>
</head>
<body>
    <%
        String str = request.getHeader("Accept-Language");
        Page p = new Page();
        p.setTotalPage(10);
        p.setCurrentPage(10);
        request.setAttribute("p",p);
    %>
    <h1>${header["Accept-Language"]}</h1>
    <h1>姓名：${param["name"]}，他的年龄是：${param.age}</h1>
    <c:set var="num" value="999" scope="session"/>
    <h1>${sessionScope.num}  <c:out value="${sessionScope.num}" /></h1>
    <c:remove var="num" scope="session" />

    <c:set var="isLastPage" value="${p.currentPage==p.totalPage}" scope="page" />
    ${isLastPage}
    <c:if test="${isLastPage }">
        <h1>Hello World!</h1>
    </c:if>
</body>
</html>
