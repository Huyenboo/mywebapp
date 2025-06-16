<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>新規登録</title>
  <style>
    body {
      font-family: "Yu Gothic UI", sans-serif;
      background-color: #e6f0fa;
      background-image: url("https://www.transparenttextures.com/patterns/flowers.png");
      background-repeat: repeat;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }
    .register-box {
      background-color: white;
      padding: 40px;
      border-radius: 15px;
      box-shadow: 0 8px 20px rgba(0,0,0,0.1);
      width: 90%;
      max-width: 500px;
      animation: fadeIn 0.6s ease-in-out;
    }
    h1 {
      color: #2c7be5;
      font-size: 24px;
      text-align: center;
      margin-bottom: 30px;
    }
    form {
      display: flex;
      flex-direction: column;
    }
    label {
      margin-bottom: 5px;
      color: #333;
      font-size: 14px;
    }
    input[type="text"], input[type="email"], input[type="password"] {
      padding: 10px;
      margin-bottom: 20px;
      border: 1px solid #ccc;
      border-radius: 8px;
      font-size: 16px;
    }
    .btn {
      padding: 12px;
      background-color: #2c7be5;
      color: white;
      font-size: 16px;
      border: none;
      border-radius: 20px;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }
    .btn:hover {
      background-color: #1d5dc0;
    }
    .link {
      text-align: center;
      margin-top: 15px;
    }
    .link a {
      color: #2c7be5;
      text-decoration: none;
      font-size: 14px;
    }
    .link a:hover {
      text-decoration: underline;
    }
    @keyframes fadeIn {
      from { opacity: 0; transform: translateY(20px); }
      to { opacity: 1; transform: translateY(0); }
    }
  </style>
</head>
<body>
  <div class="register-box">
    <h1>新規登録</h1>
    <form action="../register" method="post">
      <label for="userId">ユーザーID</label>
      <input type="text" id="userId" name="userId" required>

      <label for="name">お名前</label>
      <input type="text" id="name" name="name" required>

      <label for="email">メールアドレス</label>
      <input type="email" id="email" name="email" required>

      <label for="password">パスワード</label>
      <input type="password" id="password" name="password" required>

      <button class="btn" type="submit">登録</button>
    </form>
    <div class="link">
      <a href="login.jsp">すでにアカウントをお持ちの方はこちら</a>
    </div>
  </div>
</body>
</html>
