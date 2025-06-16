<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.company" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>会社情報一覧</title>
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
            width: 95%;
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
    <h2>会社情報一覧</h2>

    <%
        List<company> companyList = (List<company>) session.getAttribute("companyList");
    %>

    <div class="summary">
        <%= (companyList != null) ? companyList.size() : 0 %> 社
    </div>

    <table>
        <tr>
            <th>会社名</th>
            <th>住所</th>
            <th>代表電話番号</th>
            <th>担当者</th>
            <th>担当者の携帯番号</th>
        </tr>
        <%
            if (companyList != null && !companyList.isEmpty()) {
                for (company c : companyList) {
        %>
        <tr>
            <td><%= c.getCompanyName() %></td>
            <td><%= c.getAddress() %></td>
            <td><%= c.getPhone() %></td>
            <td><%= c.getContactPerson() %></td>
            <td><%= c.getContactMobile() %></td>
        </tr>
        <%
                }
            } else {
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
