package com.example.generalms.controller;

import com.example.generalms.entity.SysUser;
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


    public void login() {

    }

    @PostMapping("register")
    public void register(@RequestBody SysUser user) {
        System.out.println("接收到的数据" + user);

    }
}
