package com.example.generalms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author fuqiang
 * @dateTime: 2022/11/24 23:19
 **/
@Configuration
@MapperScan("com.example.generalms.mapper")
public class MybatisPlusConfig {
}
