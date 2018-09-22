package org.wlgzs.hospitalmanage.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author:胡亚星
 * @createTime 2018-08-20 10:07
 * @description:
 **/
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器启动!!!");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String url = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        System.out.println(url);
        HttpSession session = httpRequest.getSession();
        if (session.getAttribute("user") != null) {
            System.out.println("前台通过");
            filterChain.doFilter(httpRequest, httpResponse);
            return;
        } else {
//            filterChain.doFilter(httpRequest, httpResponse);
            if(url.equals("/toHome")||url.equals("/toHospital")){
                httpResponse.sendRedirect("/toLogin");
            }else{
                httpResponse.sendRedirect("../toLogin");
            }
            return;
        }
    }

    @Override
    public void destroy() {

    }

}
