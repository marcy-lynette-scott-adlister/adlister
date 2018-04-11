package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "controllers.ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        User loggedInUser = (User)request.getSession().getAttribute("user");
        String userUrl = loggedInUser.getUrl();
        if(userUrl == null){
            userUrl = "https://upload.wikimedia.org/wikipedia/commons/9/93/Default_profile_picture_%28male%29_on_Facebook.jpg";
        }
        List<Ad> userAds = DaoFactory.getAdsDao().userAds(loggedInUser.getId());
        request.setAttribute("userUrl", userUrl);
        request.setAttribute("userAds", userAds);

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("Edit");
        String description = request.getParameter("Description");
        Long id = Long.parseLong(request.getParameter("Update"));
        User user = (User)request.getSession().getAttribute("user");
        Ad ad = new Ad(id, user.getId(), title, description);
        DaoFactory.getAdsDao().updateAd(ad);

        response.sendRedirect("/profile");
    }
}
