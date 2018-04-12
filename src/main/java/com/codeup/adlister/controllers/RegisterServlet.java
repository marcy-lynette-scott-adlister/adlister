package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("confirm_password");

        request.getSession().setAttribute("username", username);
        request.getSession().setAttribute("email", email);

        User usernameCheck = DaoFactory.getUsersDao().findByUsername(username);
        User useremailCheck = DaoFactory.getUsersDao().findByEmail(email);

        // validate input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty();
        boolean passwordsMatch = password.equals(passwordConfirmation);

        if(inputHasErrors){
            request.getSession().setAttribute("message", "All fields required!");
        } else if (usernameCheck != null) {
            request.getSession().setAttribute("message", "Username already taken!");
        } else if (useremailCheck != null) {
            request.getSession().setAttribute("message", "There is already an account with that email!");
        } else if(!passwordsMatch) {
            request.getSession().setAttribute("message", "Passwords don't match!");
        }

        if (inputHasErrors || usernameCheck != null || useremailCheck != null || !passwordsMatch) {
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
