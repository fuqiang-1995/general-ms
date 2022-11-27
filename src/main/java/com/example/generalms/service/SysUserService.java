package com.example.generalms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.generalms.entity.SysUser;

/**
 * @author fuqiang
 * @dateTime: 2022/11/24 22:51
 **/
public interface SysUserService extends IService<SysUser> {

    SysUser getUserInfoById(Long id);

    SysUser getUserInfoByName(String name);
}
