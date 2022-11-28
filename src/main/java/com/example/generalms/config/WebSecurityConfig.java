package com.example.generalms.config;

import com.example.generalms.entity.SecurityUser;
import com.example.generalms.entity.SysUser;
import com.example.generalms.security.MyFilterSecurityInterceptor;
import com.example.generalms.security.filter.LoginFilter;
import com.example.generalms.security.handler.*;
import com.example.generalms.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author fuqiang
 * @dateTime: 2022/11/24 23:26
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    SysUserService sysUserService;
    @Autowired
    AuthenticationConfiguration authenticationConfiguration;
    @Autowired
    MyFilterSecurityInterceptor myFilterSecurityInterceptor;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().permitAll();
        http.formLogin();
        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessHandler(new MyLogoutSuccessHandler());
        http.exceptionHandling()
                .accessDeniedHandler(new MyAccessDeniedHandler())
                .authenticationEntryPoint(new MyAuthenticationEntryPoint());
        http.csrf().disable();
        // 认证部分
        http.addFilterAt(loginFilter(), UsernamePasswordAuthenticationFilter.class);
        // 授权部分
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);

        return http.build();
    }

    @Bean
    public LoginFilter loginFilter() {
        LoginFilter loginFilter = new LoginFilter();
        loginFilter.setFilterProcessesUrl("/login");
        loginFilter.setUsernameParameter("username");
        loginFilter.setPasswordParameter("password");
        loginFilter.setAuthenticationSuccessHandler(new MyAuthenticationSuccessHandler());
        loginFilter.setAuthenticationFailureHandler(new MyAuthenticationFailureHandler());
        return loginFilter;
    }

    // 自定义用户查询数据源，获得数据库中的用户信息
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            SysUser sysUser = sysUserService.getUserInfoByName(username);
            if (sysUser == null) {
                throw new UsernameNotFoundException("该用户不存在");
            }
            SecurityUser securityUser = new SecurityUser();
            // TODO 这里的转换不太正确，可能后面会修改成MapStruct
            BeanUtils.copyProperties(sysUser, securityUser);
            return securityUser;
        };
    }

    // 编写AuthenticationManager的Bean
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


}
