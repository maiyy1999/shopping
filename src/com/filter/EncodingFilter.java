package com.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding  = filterConfig.getInitParameter("encoding111");

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        //设置请求对象的编码
        servletRequest.setCharacterEncoding(encoding);
        //设置响应对象的编码
        servletResponse.setCharacterEncoding(encoding);
        servletResponse.setContentType("text/html;charset=utf-8");
        //继续执行请求的URL

        filterChain.doFilter(servletRequest,servletResponse);


    }

    //销毁资源：在web服务器关闭时执行
    @Override
    public void destroy() {

    }
}
