package com.cppor.codes.jspLearn.tag;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by willi on 07/10/2016.
 */
public class MyTag extends SimpleTagSupport {
    JspContext context = null;

    @Override
    public void setJspContext(JspContext pc) {
        context = pc;
        super.setJspContext(pc);
    }

    @Override
    public void doTag() throws JspException, IOException {
        if (context != null) {
            PageContext pc = (PageContext)context;

            ServletRequest request = pc.getRequest();
            String ip = request.getRemoteHost();

            pc.getOut().write("IP地址是：" + ip);
        }
        super.doTag();
    }
}
