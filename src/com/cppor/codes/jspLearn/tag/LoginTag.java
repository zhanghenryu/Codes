package com.cppor.codes.jspLearn.tag;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by ZhangHY on 2016/10/9.
 */
public class LoginTag extends SimpleTagSupport {

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;

    @Override
    public void doTag() throws JspException, IOException {
        HttpServletResponse res = (HttpServletResponse)((PageContext)this.getJspContext()).getResponse();
        res.setContentType("text/html;charset=utf-8");

        JspWriter out = this.getJspContext().getOut();
        out.write(
                "<table>" +
                        "<tr>" +
                        "<td>用户名：<input type='text' name='" + username + "' />" +
                        "</td>" +
                        "</tr>" +
                        "<tr><td>密码：<input  type='password' name='" + password + "'/></td></tr>" +
                        "</table>");
        super.doTag();
    }
}
