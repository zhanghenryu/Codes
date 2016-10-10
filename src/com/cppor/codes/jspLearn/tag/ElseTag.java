package com.cppor.codes.jspLearn.tag;

import org.apache.jasper.tagplugins.jstl.core.Choose;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by ZhangHY on 2016/10/9.
 */
public class ElseTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {

        ChooseTag ct = (ChooseTag) this.getParent();
        if (!ct.isFlag()) {
            this.getJspBody().invoke(null);
        }
    }
}
