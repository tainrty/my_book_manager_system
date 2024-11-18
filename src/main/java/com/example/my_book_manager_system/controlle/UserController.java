package com.example.my_book_manager_system.controlle;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.my_book_manager_system.comment.Result;
import com.example.my_book_manager_system.entity.User;
import com.example.my_book_manager_system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    // 全部查询
    @GetMapping("/findall")
    public Result queryUser() {
        List<User> users = userMapper.selectList(null);
        return Result.success(users);
    }

    // 分页查询（无模糊条件）
    @GetMapping("/page")
    public Result queryUserPage(@RequestParam(defaultValue = "1") int pageNum,
                                @RequestParam(defaultValue = "10") int pageSize) {
        Page<User> page = new Page<>(pageNum, pageSize);
        IPage<User> ipage = userMapper.selectPage(page, null);
        return Result.success(ipage);
    }

    // 分页模糊查询
    @GetMapping("/query")
    public Result queryUserByUsername(@RequestParam(defaultValue = "") String username,
                                      @RequestParam(defaultValue = "1") int pageNum,
                                      @RequestParam(defaultValue = "10") int pageSize) {
        // 创建分页对象
        Page<User> page = new Page<>(pageNum, pageSize);

        // 创建查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 模糊查询：根据用户名进行模糊查询
        queryWrapper.like("username", username);

        // 执行分页查询
        IPage<User> ipage = userMapper.selectPage(page, queryWrapper);

        // 返回结果
        return Result.success(ipage);
    }


    @DeleteMapping("/deleteBatchIds")
    public Result delete1BatchIds(@RequestParam String userIds) {

        String[] userIdArray = userIds.split(",");
        List<Long> userIdList = Arrays.stream(userIdArray)
                .map(Long::parseLong)
                .collect(Collectors.toList());

        boolean result = userMapper.deleteBatchIds(userIdList) > 0;
        if (result) {
            return Result.success("删除成功"); // 使用 Result.success() 返回成功消息
        } else {
            return Result.error("-1", "删除失败"); // 使用 Result.error() 返回失败信息
        }

    }



    // 新增用户
    @PostMapping("/add")
    public Result addUser(@RequestBody User user) {
        // 检查用户名是否已存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", user.getUsername());
        User existingUser = userMapper.selectOne(queryWrapper);

        if (existingUser != null) {
            return Result.error("-1", "用户名已存在");
        }

        // 插入新用户
        int rows = userMapper.insert(user);
        if (rows > 0) {
            return Result.success("新增成功");
        } else {
            return Result.error("-1", "新增失败");
        }
    }



    @PutMapping("/update")
    public Result updateUser(@RequestBody User user) {
        int updatedRows = userMapper.updateById(user);
        if (updatedRows > 0) {
            return Result.success("修改成功");
        } else {
            return Result.error("-1", "修改失败，用户信息未更改");
        }
    }

}
