package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
    User addUserService(User user);

    Iterable<User> getAllUsersService();

    Iterable<User> getUserByIdService(Integer id);

    User updateUserService(Integer id, User user);

    void deleteByIdService(Integer id);
}
