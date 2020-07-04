package com.WangNing.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("UTF-8");
        //2.获取数据
        //验证码
        String checkCode = request.getParameter("checkCode");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //验证验证码是否匹配
        HttpSession session=request.getSession();
        String code = (String) session.getAttribute("checkCode");
        //删除域中的验证码
        System.out.println("{"+code+"}");
        session.removeAttribute("checkCode");
        //3.判定验证码 是否正确忽略大小写
        if (checkCode!=null && checkCode.equalsIgnoreCase(code)){
            if ("aaa".equals(username) && "aaa".equals(password)){
                //登陆成功，进入a界面的所有目录导航页
                session.setAttribute("user",username);
                //重定向
                System.out.println(request);
                request.getRequestDispatcher("/main.jsp").forward(request,response);

            }else if ("bbb".equals(username) && "bbb".equals(password)){
                //登陆成功，进入b界面的所有目录导航页
                session.setAttribute("user",username);
                //重定向
                request.getRequestDispatcher("/main.jsp").forward(request,response);

            }else {
                //登陆失败
                //存储错误信息到request
                request.setAttribute("Login_error","用户名或密码错误");
                //跳转到登陆
                request.getRequestDispatcher("/index.jsp").forward(request,response);
            }
        }else {
            //验证码输入错误
            request.setAttribute("checkCode_error","验证码输入错误");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
