package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "controllers.AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Ad> adCats = DaoFactory.getAdsDao().all();
        adCats.forEach(ad -> {

            ad.setCategory(DaoFactory.getCategoriesDao().categoryName(ad.getId()));

        });

        request.setAttribute("ads", adCats);

        request.getRequestDispatcher("/WEB-INF/ads/index.jsp").forward(request, response);
    }
}
