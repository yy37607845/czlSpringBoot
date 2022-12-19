package com.example.czldemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.czldemo.mapper.auto.UserMapper;
import com.example.czldemo.model.auto.User;
import com.example.czldemo.service.IUserService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author czl
 * @since 2021-12-01
 */
@Primary
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User selectUserById(String id) {
        User user =  userMapper.selectById(id);
        return user;
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }
}
