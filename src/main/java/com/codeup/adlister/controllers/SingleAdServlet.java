package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "SingleAdServlet", urlPatterns = "/showad")
public class SingleAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Ad ad = new Ad();
        for (Ad single: DaoFactory.getAdsDao().all()) {
            if (single.getId() == id){
                ad = single;
            }
        }
        String category = DaoFactory.getCategoriesDao().categoryName(id);
        request.setAttribute("category", category);




        request.setAttribute("ad", ad);
        request.getRequestDispatcher("/WEB-INF/ads/showad.jsp").forward(request, response);

    }
}
