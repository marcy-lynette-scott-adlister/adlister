package com.codeup.adlister.dao;

import com.codeup.adlister.Config;
import com.codeup.adlister.models.Category;

import javax.xml.transform.Result;
import java.sql.*;

public class MySQLCategoriesDao implements Categories {
    private Connection connection = null;

    public MySQLCategoriesDao() {
        connection = Config.connectDatabase();
    }

    @Override
    public Long insertCategory(Category category) {
        try{
            String insertQuery = "INSERT INTO categories(category) VALUES (?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, category.getCategory());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting category.", e);
        }
    }

    @Override
    public void insertCatAndAdId(Long category_id, Long id) {
        try{
            String query = "Insert into category_ads(category_id,ad_id) values(?,?)";
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, category_id);
            stmt.setLong(2, id);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting id's.", e);
        }
    }


}