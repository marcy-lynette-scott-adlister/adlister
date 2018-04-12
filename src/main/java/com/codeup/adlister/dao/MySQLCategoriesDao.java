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
            String insertQuery = "INSERT INTO categories(category) VALUES (?) ";
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
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, category_id);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error inserting id's.", e);
        }
    }

    @Override
    public String categoryName(Long ad_id) {
        try{
            String query = "Select category from categories as c join category_ads as ca on c.id = ca.category_id where ca.ad_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, ad_id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                return rs.getString(1);
            }
            else {
                return "";
            }
        }
        catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error finding category.", e);
        }
    }

    @Override
    public void updateCategory(String category, Long ad_id) {
        String query = "UPDATE category_ads ca, (select category, id from categories) c set ca.category_id = c.id where c.category = ? and ca.ad_id = ?";
        try{
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, category);
            stmt.setLong(2, ad_id);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException("Error updating category.", e);
        }
    }

    @Override
    public Category checkCategoryExists(String category) {
        String query = "SELECT * FROM categories WHERE category = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            if (!rs.next()) {
                return null;
            }
            else{
                return new Category(
                        rs.getLong("id"),
                        rs.getString("category")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public boolean findCategoryByAdId(Long ad_id) {
        String query = "SELECT category_id from category_ads WHERE ad_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, ad_id);
            ResultSet rs = stmt.executeQuery();
            return(rs.next());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding an ad by ID", e);
        }
    }


}
