package com.cppor.codes.jspLearn.servlet;

import javafx.application.Application;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

/**
 * Created by ZhangHY on 2016/9/27.
 */
public class ServletLogin extends javax.servlet.http.HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Servlet Init : " + Calendar.getInstance().toString());
        super.init(config);
        
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        response.setHeader("content-type", "application/json; charset=utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if ("henry".equals(username) && "henry".equals(password)) {
            Cookie loginCookie = new Cookie("session", UUID.randomUUID().toString());
            response.addCookie(loginCookie);
            Cookie usernameCookie = new Cookie("username", username);
            response.addCookie(usernameCookie);

            request.getSession().setAttribute("logininfo", loginCookie.getValue());
            request.getSession().setAttribute("username",username);

            response.sendRedirect("index.jsp");
            //response.getWriter().write("{'result':'success'}");
        } else {
            response.getWriter().write("{'result':'failure', message:'密码错误'}");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        HttpSession session = request.getSession();
        Cookie loginCookie = new Cookie("logined", UUID.randomUUID().toString());
        response.addCookie(loginCookie);
        session.setAttribute("logined", loginCookie.getValue());

        response.getWriter().write("success");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destory:" + Calendar.getInstance().toString());
        super.destroy();
    }
}
