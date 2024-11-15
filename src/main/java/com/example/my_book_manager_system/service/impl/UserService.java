package service.impl;

import entity.User;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import service.IUserService;
import org.springframework.stereotype.Service;  // 添加 @Service 注解
import java.util.Collections;
import java.util.List;

@Service  // 让 Spring 知道这是一个服务类，自动注册到 Spring 容器中
public class UserService implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> listUsers() {
        return userMapper.listUsers();
    }
}
