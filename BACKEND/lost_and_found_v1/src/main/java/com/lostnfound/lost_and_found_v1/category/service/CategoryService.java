package com.lostnfound.lost_and_found_v1.category.service;

import java.util.List;

import com.lostnfound.lost_and_found_v1.category.entity.Category;

public interface CategoryService {

    public Category setCategory(Category category);
    public List<Category> getAllCategory();
    public Category getCategoryById(Long id);
    public Category updateCategory(Category category,Long id);

}
