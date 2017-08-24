<%--
  User: 果占先
  Date: 2017/8/23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <title>药品信息管理</title>
    <link rel="stylesheet" href="styles/demo.css"/>
    <script>
        function addDrug() {
            document.getElementById('form1').submit();
        }
    </script>
</head>
<body>
<div style="width:60%;margin: auto auto;">
    <form action="addDrug2.action" method="post" id="form1" enctype="multipart/form-data">
    <fieldset>
        <legend>
            添加药品信息
        </legend>
        <div class="form-group">
            <label>药品编号:</label>
            <input type="text" name="drugId"/>
        </div>
        <div class="form-group">
            <label>药品名称:</label>
            <input type="text" name="drugName"/>
        </div>
        <div class="form-group">
            <label>药品价格:</label>
            <input type="text" name="drugPrice"/>
        </div>
        <div class="form-group">
            <label>药品出厂日期:</label>
            <input type="date" name="drugDate"/>
        </div>
        <div class="form-group">
            <label>药品图片:</label>
            <input type="file" name="drugPic"/>
        </div>
        <div class="form-group">
            <label></label>
            <button onclick="addDrug()">添加</button>
        </div>
    </fieldset>
    </form>
    <table>
        <thead>
        <tr>
            <th>药品编号</th>
            <th>药品名称</th>
            <th>药品价格</th>
            <th>药品出厂日期</th>
            <th>操作</th>
            <th>药品图片</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="d" items="${requestScope.p.list}">
            <tr>
                <td>${d.drug_id}</td>
                <td>${d.drug_name}</td>
                <td>${d.drug_price}</td>
                <td><fmt:formatDate value="${d.drug_date}" pattern="yyyy-MM-dd"/> </td>
                <td class="'text-center'">
                    <button>Delete</button>
                </td>
                <td><img src="upload/${d.drug_id}/${d.drug_pic}" width="64" height="64"></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div>
        <ul class="pagination">
            <li>
                <c:if test="${requestScope.p.currentPage>1}">
                    <a href="findDrugs.action?page=${requestScope.p.currentPage-1}">上一页</a>
                </c:if>
                <c:forEach begin="1" end="${requestScope.p.totalPage}" varStatus="aaa">
                    <c:choose>
                        <c:when test="${aaa.index==requestScope.p.currentPage}">
                            <a href="findDrugs.action?page=${aaa.index}" class="active">${aaa.index}</a>
                        </c:when>
                        <c:otherwise>
                            <a href="findDrugs.action?page=${aaa.index}">${aaa.index}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${requestScope.p.currentPage<requestScope.p.totalPage}">
                    <a href="findDrugs.action?page=${requestScope.p.currentPage+1}">下一页</a>
                </c:if>
            </li>
        </ul>
    </div>
</div>
</body>
</html>
