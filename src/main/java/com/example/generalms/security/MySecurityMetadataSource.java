package com.example.generalms.security;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;

/**
 * 这个类用于获取 某个请求所需要的权限
 */
@Component
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 1. 获取请求路径的URI
        String uri = ((FilterInvocation) object).getRequest().getRequestURI();
        // 2. 从自定义数据源中获得权限数据与对应的URI

        // 3. 遍历数据源信息与请求路径的URI进行匹配，匹配完成返回对应的权限信息


        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
