<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>ログイン</title>
  <style>
    body {
      font-family: "Yu Gothic UI", sans-serif;
      background-color: #f0f4f8;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .login-box {
      background: white;
      padding: 40px;
      border-radius: 15px;
      box-shadow: 0 8px 20px rgba(0,0,0,0.1);
      width: 90%;
      max-width: 400px;
    }
    h2 {
      text-align: center;
      color: #2c7be5;
      margin-bottom: 30px;
    }
    label {
      margin-bottom: 5px;
      display: block;
      color: #333;
    }
    input[type="text"], input[type="password"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 20px;
      border: 1px solid #ccc;
      border-radius: 8px;
    }
    .btn {
      width: 100%;
      padding: 12px;
      background-color: #2c7be5;
      color: white;
      border: none;
      border-radius: 20px;
      cursor: pointer;
    }
    .btn:hover {
      background-color: #1d5dc0;
    }
    .error {
      color: red;
      text-align: center;
      margin-bottom: 10px;
    }
  </style>
</head>
<body>
  <div class="login-box">
    <h2>ログイン</h2>
    <form action="../login" method="post">
      <label for="userId">ユーザーID</label>
      <input type="text" name="userId" id="userId" required>

      <label for="password">パスワード</label>
      <input type="password" name="password" id="password" required>

      <button type="submit" class="btn">ログイン</button>
    </form>

    <% String error = (String) request.getAttribute("error"); %>
    <% if (error != null) { %>
      <div class="error"><%= error %></div>
    <% } %>
  </div>
</body>
</html>
