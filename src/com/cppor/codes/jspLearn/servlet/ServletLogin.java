package com.cppor.codes.jspLearn.servlet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import javafx.application.Application;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    static final String DIRVER = "com.mysql.jdbc.Driver";
    static String DB = "jdbc:mysql://localhost:3306/jeesite";
    protected String login(String user, String pwd) throws ClassNotFoundException {
        // 都说是注册数据库驱动，但是我没看出来，所以估计得看一下

        String result = "";
        try {
            Class.forName(DIRVER);//.newInstance();
            try (java.sql.Connection connection = DriverManager.getConnection(DB, "jeesite", "jeesite")) {
                try (java.sql.Statement stat = connection.createStatement()) {
                    try (ResultSet resultSet = stat.executeQuery("SELECT PWD_ FROM ACT_ID_USER")) {
                        while (resultSet.next()) {
                            result += resultSet.getString(1) + ";";
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
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
String result = "";
        try {
            result = login("","");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.getWriter().write(result);
    }

    @Override
    public void destroy() {
        System.out.println("Servlet Destory:" + Calendar.getInstance().toString());
        super.destroy();
    }
}
