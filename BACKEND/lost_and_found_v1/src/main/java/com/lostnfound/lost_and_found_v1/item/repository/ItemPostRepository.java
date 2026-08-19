package com.lostnfound.lost_and_found_v1.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lostnfound.lost_and_found_v1.item.entity.ItemPost;

public interface ItemPostRepository extends JpaRepository<ItemPost, Long> {
    
}
