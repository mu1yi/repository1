package com.WangNing.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(value = "/a/*",dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE})
public class Filter1 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filterA");
        HttpServletRequest request=(HttpServletRequest)req;

        String username=(String)request.getSession().getAttribute("user");
        System.out.println(username);
        if ("aaa".equals(username)){
            chain.doFilter(req, resp);
        }else {
            HttpServletResponse response=(HttpServletResponse)resp;
            System.out.println("is bbb");
            request.getRequestDispatcher("/main.jsp").forward(request,response);
        }



    }

    public void init(FilterConfig config) throws ServletException {

    }

}
