package com.lostnfound.lost_and_found_v1.user.service;

import java.util.List;

import com.lostnfound.lost_and_found_v1.user.entity.User;

public interface UserService {
    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(long id);
    User updateUser(long id, User user);
    void deleteUser(long id);
}
