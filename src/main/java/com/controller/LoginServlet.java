package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.model.RegisterUserDAO;
import jakarta.servlet.*;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        String password = request.getParameter("password");

        RegisterUserDAO dao = new RegisterUserDAO();
        boolean valid = dao.checkLogin(userId, password);

        if (valid) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            response.sendRedirect("welcome.jsp");
        } else {
            request.setAttribute("error", "ユーザーIDまたはパスワードが違います");
            request.getRequestDispatcher(".jsp/login.jsp").forward(request, response);
        }
    }
}
