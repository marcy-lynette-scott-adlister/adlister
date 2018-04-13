package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;
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

        // assuming you have added a categoryName property to the Ad model...
        // iterate over userAds and for each Ad object, setCategoryName(whateverMethodGetsTheCategoryName())

        userAds.forEach(ad -> {
           ad.setCategory(DaoFactory.getCategoriesDao().categoryName(ad.getId()));
        });

        request.setAttribute("userUrl", userUrl);
        request.setAttribute("userAds", userAds);

        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("Edit");
        String description = request.getParameter("Description");
        Long id = Long.parseLong(request.getParameter("Update"));
        User user = (User)request.getSession().getAttribute("user");
        String url = request.getParameter("adPic");
        Ad ad = new Ad(id, user.getId(), title, description, url);
        DaoFactory.getAdsDao().updateAd(ad);
        String category = request.getParameter("category");
        Category category1 = new Category(category);

        boolean inputHasErrors = title.isEmpty() || description.isEmpty();
        boolean titleLengthCheck = title.length() > 240;
        boolean descriptionLengthCheck = title.length() > 1000;
        boolean urlLengthCheck = url.length() > 255;
        boolean categoryLengthCheck = url.length() > 100;


        if(inputHasErrors) {
            request.getSession().setAttribute("message", "All fields required!");
        } else if (titleLengthCheck) {
            request.getSession().setAttribute("message", "Title too long!");
        } else if (descriptionLengthCheck) {
            request.getSession().setAttribute("message", "Description too long!");
        } else if (categoryLengthCheck) {
            request.getSession().setAttribute("message", "Category too long!");
        } else if (urlLengthCheck) {
                request.getSession().setAttribute("message", "Url too long!");
        }
        if (inputHasErrors || titleLengthCheck || descriptionLengthCheck || urlLengthCheck || categoryLengthCheck) {
            response.sendRedirect("/ads/edit");
            return;
        }

        if (DaoFactory.getCategoriesDao().checkCategoryExists(category) == null){
            Long cat_id = DaoFactory.getCategoriesDao().insertCategory(category1);
            DaoFactory.getCategoriesDao().insertCatAndAdId(cat_id, id);
        }
        else if (DaoFactory.getCategoriesDao().findCategoryByAdId(id)) {
            DaoFactory.getCategoriesDao().updateCategory(category, id);
        }
        else {
            Long existCat_id = DaoFactory.getCategoriesDao().checkCategoryExists(category).getId();
            DaoFactory.getCategoriesDao().insertCatAndAdId(existCat_id, id);
        }


        response.sendRedirect("/profile");
    }
}
