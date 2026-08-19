package com.lostnfound.lost_and_found_v1.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lostnfound.lost_and_found_v1.category.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
