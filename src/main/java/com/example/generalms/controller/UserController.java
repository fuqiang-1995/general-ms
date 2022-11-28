package com.example.generalms.controller;

import com.example.generalms.entity.SysUser;
import com.example.generalms.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fuqiang
 * @dateTime: 2022/11/25 14:17
 **/
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    SysUserService sysUserService;


    @PostMapping("register")
    public boolean register(@RequestBody SysUser user) {
        System.out.println("接收到的数据" + user);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword("{bcrypt}" + encoder.encode(user.getPassword()));
        return sysUserService.save(user);
    }
}
