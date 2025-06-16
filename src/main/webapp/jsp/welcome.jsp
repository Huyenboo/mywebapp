<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<%
    HttpSession session = request.getSession(false);
    if (session == null || session.getAttribute("userId") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
    String userId = (String) session.getAttribute("userId");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>ようこそ</title>
</head>
<body>
  <h2><%= userId %> さん、ようこそ！</h2>
  <a href="logout.jsp">ログアウト</a>
</body>
</html>
