package com.WangNing.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/b/*",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE})
public class Filter2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterB");
        HttpServletRequest request=(HttpServletRequest)req;
        String username=(String)request.getSession().getAttribute("user");
        System.out.println(username);
        if ("bbb".equals(username)){
            chain.doFilter(req, resp);
        }else {
            HttpServletResponse response=(HttpServletResponse)resp;
            System.out.println("is aaa");
            request.getRequestDispatcher("/main.jsp").forward(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
