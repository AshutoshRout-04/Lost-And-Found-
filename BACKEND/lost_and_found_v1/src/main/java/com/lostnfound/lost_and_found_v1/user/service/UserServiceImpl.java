package com.lostnfound.lost_and_found_v1.user.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.lostnfound.lost_and_found_v1.user.entity.User;
import com.lostnfound.lost_and_found_v1.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
    }
    @Override
    public User updateUser(long id, User user){
        User existingUser = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(existingUser);
    }
    
    @Override
    public void deleteUser(long id){
        userRepository.deleteById(id);
    }

    
    
}
