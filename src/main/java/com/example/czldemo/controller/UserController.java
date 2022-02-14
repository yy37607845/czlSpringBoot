package com.example.czldemo.controller;


import com.example.czldemo.model.auto.User;
import com.example.czldemo.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author czl
 * @since 2021-12-01
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    //@Qualifier("userServiceImpl")
    private IUserService userService;

    @PostMapping("selectUserById")
    public String selectUserById(String id){
        User user = userService.selectUserById(id);
        return user.getName();
    }

    @PostMapping("addUser")
    @ResponseBody
    public void addUser(@RequestBody User user){
        userService.addUser(user);
        logger.info("添加成员成功");
    }

}
