<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.Employee" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>社員一覧（Employees List）</title>
    <style>
        body {
            font-family: "Segoe UI", sans-serif;
            background-color: #f4f8fb;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        table {
            border-collapse: collapse;
            width: 90%;
            margin: 20px auto;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 10px 15px;
            border: 1px solid #ccc;
            text-align: center;
        }

        th {
            background-color: #e0eaff;
            color: #333;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .no-data {
            text-align: center;
            color: red;
        }

        .summary {
            text-align: center;
            font-weight: bold;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
    <h2>社員一覧（Employees List）</h2>

    <%
        List<Employee> list = (List<Employee>) request.getAttribute("employeeList");
    %>

    <div class="summary">
        社員数: <%= (list != null) ? list.size() : 0 %> 名
    </div>

    <table>
        <tr>
            <th>ID</th>
            <th>氏名</th>
            <th>性別</th>
            <th>部署</th>
            <th>入社日</th>
        </tr>
        <%
            if (session != null) {
            	List<Employee> empList = (List<Employee>) session.getAttribute("empList");
            	for(Employee emp : empList){
        %>
        <tr>
            <td><%= emp.getId() %></td>
            <td><%= emp.getName() %></td>
            <td><%= emp.getGender() %></td>
            <td><%= emp.getDepartment() %></td>
            <td><%= emp.getHireDate() %></td>
        </tr>
        <%
                
            	}} else {
        %>
        <tr>
            <td colspan="5" class="no-data">データがありません。</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
