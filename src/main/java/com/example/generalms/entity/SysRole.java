package com.example.generalms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author fuqiang
 * @dateTime: 2022/11/24 22:50
 **/
@Data
@TableName("sys_role")
public class SysRole {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String roleCode;
    private String roleName;
}
