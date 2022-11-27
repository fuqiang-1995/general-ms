package com.example.generalms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.generalms.entity.SysUser;
import com.example.generalms.mapper.SysUserMapper;
import com.example.generalms.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author fuqiang
 * @dateTime: 2022/11/24 22:53
 **/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser getUserInfoById(Long id) {
        return sysUserMapper.getUserInfoById(id);
    }

    @Override
    public SysUser getUserInfoByName(String name) {
        return sysUserMapper.getUserInfoByName(name);
    }
}
