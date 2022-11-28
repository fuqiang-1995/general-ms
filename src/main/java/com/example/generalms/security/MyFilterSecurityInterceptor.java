package com.example.generalms.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

    @Autowired
    MySecurityMetadataSource mySecurityMetadataSource;

    @Autowired
    public void setMyAccessDecisionManager(MyAccessDecisionManager myAccessDecisionManager) {
        super.setAccessDecisionManager(myAccessDecisionManager);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // invocation里面有一个被拦截的URL
        // 里面调用 MySecurityMetadataSource 的getAttributes(Object object)这个方法获取invocation对应的所有权限
        // 再调用 MyAccessDecisionManager的decide方法来校验用户的权限是否足够
        FilterInvocation invocation = new FilterInvocation(servletRequest, servletResponse, filterChain);
        InterceptorStatusToken token = super.beforeInvocation(invocation);
        // 执行下一个拦截器
        invocation.getChain().doFilter(invocation.getRequest(), invocation.getResponse());
        super.afterInvocation(token, null);
    }

    @Override
    public Class<?> getSecureObjectClass() {
        return FilterInvocation.class;
    }

    @Override
    public SecurityMetadataSource obtainSecurityMetadataSource() {
        return this.mySecurityMetadataSource;
    }


}
