package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;

public interface Categories {
    Long insertCategory(Category category);
    void insertCatAndAdId(Long id, Long category_id);
}