package com.lostnfound.lost_and_found_v1.category.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lostnfound.lost_and_found_v1.category.entity.Category;
import com.lostnfound.lost_and_found_v1.category.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("set")
    public Category setCategory(@RequestBody Category category) {
        return categoryService.setCategory(category);
    }

    @GetMapping("get/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("getAll")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }

    @PutMapping("update/{id}")
    public Category updateCategory(@RequestBody Category category ,@PathVariable Long id) {
        return categoryService.updateCategory(category,id);
    }
    
}
