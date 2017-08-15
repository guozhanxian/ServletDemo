<%@ page import="java.util.List" %>
<%@ page import="com.ralph.domain.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
</head>
<body>
    <button onclick="addStudent()">添加学生信息</button>
    <table width="60%" border="1" cellpadding="0" cellspacing="0">
        <thead>
            <tr>
                <th>学号</th>
                <th>姓名</th>
                <th>年龄</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<Student> list = (List<Student>) request.getAttribute("list");
                for(int i=0;i<list.size();i++)
                {
                    Student s = list.get(i);
            %>
            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getName()%></td>
                <td><%=s.getAge()%></td>
                <td><a href="">更新</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="">删除</a></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <script>
        function addStudent() {
            window.location.href = 'registStudent.html';
        }
    </script>
</body>
</html>
