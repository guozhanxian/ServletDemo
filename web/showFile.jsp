<%@ page import="java.io.File" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: guozhanxian
  Date: 2017/8/15
  Time: 上午9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <table width="50%">
        <%
            File[] fs = (File[]) request.getAttribute("fs");
            for(int i=0;i<fs.length;i++)
            {
        %>
        <tr>
            <%
               if(fs[i].isDirectory())
               {
            %>
            <td><a href="showFile.action?type=1&dir=<%=URLEncoder.encode(fs[i].getAbsolutePath(),"utf-8")%>"><%=fs[i].getName()%></a></td>
            <%
                }else{
            %>
            <td><a href="showFile.action?type=2&dir=<%=URLEncoder.encode(fs[i].getAbsolutePath(),"utf-8")%>"><%=fs[i].getName()%></a></td>
            <%
                }
            %>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
