package com.example.generalms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author fuqiang
 * @dateTime: 2022/11/24 22:48
 **/
@Data
@TableName("sys_user")
public class SysUser {
    @TableId(type = IdType.AUTO)
    private Long id;
    @JsonProperty("username")
    private String userName;
    private String nickName;
    private String password;

    private List<SysRole> roles;
}
