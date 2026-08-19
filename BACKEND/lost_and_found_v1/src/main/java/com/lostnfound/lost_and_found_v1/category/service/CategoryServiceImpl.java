package com.lostnfound.lost_and_found_v1.category.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lostnfound.lost_and_found_v1.category.entity.Category;
import com.lostnfound.lost_and_found_v1.category.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    
    @Override
    public Category setCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found"));
    }

    @Override
    public Category updateCategory(Category category ,Long id) {
        Category existingCategory = categoryRepository.findById(category.getId()).orElseThrow(() -> new RuntimeException("Category Not Found"));
        existingCategory.setName(category.getName());
        return categoryRepository.save(existingCategory);
    }
}
