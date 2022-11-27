package com.example.generalms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.generalms.entity.SysUser;
import org.springframework.stereotype.Repository;

/**
 * @author fuqiang
 * @dateTime: 2022/11/24 22:47
 **/
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {
    SysUser getUserInfoById(Long id);

    SysUser getUserInfoByName(String name);
}
