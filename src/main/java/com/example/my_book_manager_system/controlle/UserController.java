package com.example.my_book_manager_system.controlle;

import com.example.my_book_manager_system.comment.Result;
import com.example.my_book_manager_system.entity.User;
import com.example.my_book_manager_system.service.impl.UserService;
import com.example.my_book_manager_system.comment.request.UserPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Result list() {
        List<User> users = userService.list();
        return Result.success(users);
    }

    @GetMapping("/page")
    public Result page(UserPageRequest userPageRequest) {
        // 调用分页服务方法，返回分页数据
        return Result.success(userService.page(userPageRequest));
    }
}
