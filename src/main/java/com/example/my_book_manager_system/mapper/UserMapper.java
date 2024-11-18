package com.example.my_book_manager_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.example.my_book_manager_system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {}

