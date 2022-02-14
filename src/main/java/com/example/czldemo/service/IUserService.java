package com.example.czldemo.service;

import com.example.czldemo.model.auto.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author czl
 * @since 2021-12-01
 */
public interface IUserService extends IService<User> {

    User selectUserById(String id);

    void addUser(User user);
}
