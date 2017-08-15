<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" session="false" errorPage="error.jsp" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%!
     int x = 99;
     String str = "Hello，你好";
     public int add(int x,int y)
     {
         return x / y;
     }
  %>
  <h1>Hello World!<%=add(3,0)%></h1>
  <h2><%=str%></h2>

  <%
      Date d = new Date();
      for(int i=0;i<100;i++)
      {
  %>
  <a href="a<%=i%>.html">这是第<%=i+1%>个超链接</a>
  <%
      }
  %>
  </body>
</html>
