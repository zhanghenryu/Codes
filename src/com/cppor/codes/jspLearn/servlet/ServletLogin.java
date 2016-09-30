package com.cppor.codes.jspLearn.servlet;

import java.io.IOException;

/**
 * Created by ZhangHY on 2016/9/27.
 */
public class ServletLogin extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        response.getWriter().write("doPost");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        response.getWriter().write("doGet");
    }
}
