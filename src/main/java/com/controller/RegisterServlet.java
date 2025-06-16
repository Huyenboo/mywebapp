package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.model.RegisterUserDAO;
import com.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(userId, name, email, password);
        RegisterUserDAO dao = new RegisterUserDAO();
        boolean success = dao.insertUser(user);

        if (success) {
            response.sendRedirect("register-success.jsp");
        } else {
            request.setAttribute("error", "登録に失敗しました。ユーザーIDがすでに存在しています。");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
