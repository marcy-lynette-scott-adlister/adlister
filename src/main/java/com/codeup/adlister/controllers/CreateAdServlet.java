package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Categories;
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

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        Category category = new Category(request.getParameter("category"));
        String url = request.getParameter("url");
        User user = (User) request.getSession().getAttribute("user");

        request.getSession().setAttribute("title", title);
        request.getSession().setAttribute("description", description);
        request.getSession().setAttribute("category", category.getCategory());
        request.getSession().setAttribute("url", url);

        boolean inputHasErrors = title.isEmpty() || description.isEmpty();
        boolean titleLengthCheck = title.length() > 240;
        boolean descriptionLengthCheck = title.length() > 1000;
        boolean urlLengthCheck = url.length() > 255;
        boolean categoryLengthCheck = category.getCategory().length() > 100;


        if(inputHasErrors) {
            request.getSession().setAttribute("message", "Title and Description required!");
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
            response.sendRedirect("/ads/create");
            return;
        }

        Ad ad = new Ad(
            user.getId(),
            title,
            description,
            url
        );
        request.getSession().removeAttribute("title");
        request.getSession().removeAttribute("description");
        request.getSession().removeAttribute("category");
        request.getSession().removeAttribute("url");

        Long id = DaoFactory.getAdsDao().insert(ad);
        Long category_id = DaoFactory.getCategoriesDao().insertCategory(category);
        DaoFactory.getCategoriesDao().insertCatAndAdId(category_id, id);
        response.sendRedirect("/ads");
    }

}
