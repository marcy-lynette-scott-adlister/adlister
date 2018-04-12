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

@WebServlet(name = "ViewSellerProfileServlet", urlPatterns = "/seller")
public class ViewSellerProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sellerUsername = (String) request.getParameter("username");
        User seller = DaoFactory.getUsersDao().findByUsername(sellerUsername);
        List<Ad> sellerAds = DaoFactory.getAdsDao().userAds(seller.getId());

        request.setAttribute("seller", seller);
        request.setAttribute("sellerAds", sellerAds);
        request.getRequestDispatcher("/WEB-INF/sellerProfile.jsp").forward(request, response);
    }
}
