package com.example.my_book_manager_system.mapper;

import com.example.my_book_manager_system.comment.request.UserPageRequest;
import com.example.my_book_manager_system.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
//    @Select("select * from user")
    List<User> list();

   List<User> listByCondition(UserPageRequest userPageRequest);
}
