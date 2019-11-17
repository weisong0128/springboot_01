package com.java.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * description：
 * author：丁鹏
 * date：16:07
 */
@WebFilter(urlPatterns = {"/*"})
public class Demo1Filter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest rq, ServletResponse rsp, FilterChain chain) throws IOException, ServletException {
        System.out.println("-------------------哈哈，我是过滤器------------------");
        chain.doFilter(rq,rsp);
    }

    @Override
    public void destroy() {

    }
}
