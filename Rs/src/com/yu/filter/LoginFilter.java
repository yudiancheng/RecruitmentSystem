package com.yu.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;
        String uri = req.getRequestURI();
        System.out.println(uri);
        if(uri.equals("/Rs/login.jsp")) {
            filterChain.doFilter(request,response);
        }
         else {
            Object user = req.getSession().getAttribute("user");
            Object company = req.getSession().getAttribute("company");
            if(user != null || company != null) {
                filterChain.doFilter(request,response);
            } else {
                resp.sendRedirect("/Rs/login.jsp");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
