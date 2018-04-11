package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.ProfileSettingsServlet", urlPatterns = "/edit")
public class ProfileSettingsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        User user = (User) request.getSession().getAttribute("user");
        String url = "";
        if(user.getUrl() != null) {
            url = user.getUrl();
        }
        request.setAttribute("url", url);
        request.getRequestDispatcher("/WEB-INF/profileSettings.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        User user = (User) request.getSession().getAttribute("user");

        //get parameters from form
        String username = request.getParameter("username").trim();
        String email = request.getParameter("email").trim();
        String url = request.getParameter("profilePic").trim();

        //check to see if username or email already exists in database and that form entries are not empty
        List<User> usernameCheck = DaoFactory.getUsersDao().editUsernameCheck(username);
        List<User> useremailCheck = DaoFactory.getUsersDao().editEmailCheck(email);

        // validate input
        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || usernameCheck.size() > 1
            || useremailCheck.size() > 1;

        if (inputHasErrors) {
            response.sendRedirect("/edit");
            return;
        }
        if (useremailCheck.size() == 0){
            user.setEmail(email);
        }
        if (usernameCheck.size() == 0) {
            user.setUsername(username);
        }
        if(url.isEmpty()){
            url = null;
        }
        user.setUrl(url);
        DaoFactory.getUsersDao().updateUser(user);
        response.sendRedirect("/profile");

    }
}
