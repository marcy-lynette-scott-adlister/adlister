package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Password;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.UpdatePasswordServlet", urlPatterns = "/update")
public class UpdatePasswordServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/profile");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");
        String oldPassword = request.getParameter("old_password");
        String newPassword = request.getParameter("new_password");
        String newPasswordConfirmation = request.getParameter("confirm_new_password");

        boolean validAttempt = Password.check(oldPassword, user.getPassword())
                && !newPassword.isEmpty()
                && !newPasswordConfirmation.isEmpty()
                && newPassword.equals(newPasswordConfirmation);
        if(newPassword.isEmpty() || newPasswordConfirmation.isEmpty()) {
            request.getSession().setAttribute("message", "All password fields required!");
        } else if(!Password.check(oldPassword, user.getPassword())) {
            request.getSession().setAttribute("message", "Password not correct!");
        } else if (!newPassword.equals(newPasswordConfirmation)) {
            request.getSession().setAttribute("message", "Passwords do not match!");
        }

        if(!validAttempt){
            response.sendRedirect("/edit");
            return;
        }
        user.setPassword(newPassword);
        DaoFactory.getUsersDao().updateUserPassword(user);
        response.sendRedirect("/profile");
    }
}
