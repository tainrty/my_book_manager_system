package com.example.my_book_manager_system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.example.my_book_manager_system.comment.request.UserPageRequest;
import com.example.my_book_manager_system.entity.User;
import com.example.my_book_manager_system.mapper.UserMapper;
import com.example.my_book_manager_system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public Object page(UserPageRequest userPageRequest) {
        // 使用 PageHelper 开始分页，传入页码和页面大小
        PageHelper.startPage(userPageRequest.getPagemun(), userPageRequest.getPagesize());

        // 根据条件查询用户数据
        List<User> users = userMapper.listByCondition(userPageRequest);

        // 使用 PageInfo 封装分页结果，包括当前页数据和分页信息
        PageInfo<User> pageInfo = new PageInfo<>(users);

        // 返回分页信息
        return pageInfo;
    }
}
