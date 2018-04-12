package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

public interface Categories {
    Long insertCategory(Category category);
    void insertCatAndAdId(Long id, Long category_id);
    String categoryName(Long ad_id);
    void updateCategory(String category, Long ad_id);
    Category checkCategoryExists(String category);
    boolean findCategoryByAdId(Long ad_id);
}
