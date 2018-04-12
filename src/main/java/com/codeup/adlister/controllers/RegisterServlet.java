package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userpic = request.getParameter("userpic");
        String passwordConfirmation = request.getParameter("confirm_password");

        request.getSession().setAttribute("username", username);
        request.getSession().setAttribute("email", email);


        User usernameCheck = DaoFactory.getUsersDao().findByUsername(username);
        User useremailCheck = DaoFactory.getUsersDao().findByEmail(email);

        // validate input


        boolean inputHasErrors = username.isEmpty()
            || email.isEmpty()
            || password.isEmpty();
        boolean userLengthCheck = username.length() > 240;
        boolean passwordLengthCheck = password.length() > 240;
        boolean emailLengthCheck = email.length() > 240;
        boolean passwordsMatch = password.equals(passwordConfirmation);

        final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

           Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
           boolean isValidEmail = matcher.find();


        if(inputHasErrors){
            request.getSession().setAttribute("message", "All fields required!");
        } else if (usernameCheck != null) {
            request.getSession().setAttribute("message", "Username already taken!");
        } else if (useremailCheck != null) {
            request.getSession().setAttribute("message", "There is already an account with that email!");
        } else if(!passwordsMatch) {
            request.getSession().setAttribute("message", "Passwords don't match!");
        } else if(emailLengthCheck) {
            request.getSession().setAttribute("message", "Email is too Long!");
        } else if(userLengthCheck) {
            request.getSession().setAttribute("message", "Username is too Long!");
        } else if(passwordLengthCheck) {
            request.getSession().setAttribute("message", "Password is too Long!");
        } else if(!isValidEmail) {
            request.getSession().setAttribute("message", "Please enter a valid email!");
        }

        if (inputHasErrors || usernameCheck != null || useremailCheck != null || !passwordsMatch || userLengthCheck || emailLengthCheck || passwordLengthCheck || !isValidEmail) {
            response.sendRedirect("/register");
            return;
        }

        // create and save a new user
        User user = new User(username, email, password);
        DaoFactory.getUsersDao().insert(user);
        response.sendRedirect("/login");
    }
}
