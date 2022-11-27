package com.example.generalms;

import com.example.generalms.entity.SysUser;
import com.example.generalms.service.SysUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author fuqiang
 * @dateTime: 2022/11/24 23:14
 **/
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    SysUserService sysUserService;
    @Test
    void getUserInfo(){
        SysUser sysUser = sysUserService.getUserInfoById(1L);
        System.out.println(sysUser);
    }
}
