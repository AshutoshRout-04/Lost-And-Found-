package com.lostnfound.lost_and_found_v1.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lostnfound.lost_and_found_v1.user.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
