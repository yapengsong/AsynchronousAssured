package com.didispace.controller;

import com.didispace.domain.p.User;
import com.didispace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Value("${server.port}")
    String port;

    @RequestMapping("/save")
    public void save(String name,Integer age){
        User user=new User();
        user.setName(name);
        user.setAge(age);
        userService.saveUser(user);
    }

}
