package com.example.my_book_manager_system.service;

import com.example.my_book_manager_system.comment.request.UserPageRequest;
import com.example.my_book_manager_system.entity.User;

import java.util.List;

public interface IUserService {
    List<User> list();


    Object page(UserPageRequest userPageRequest);
}
