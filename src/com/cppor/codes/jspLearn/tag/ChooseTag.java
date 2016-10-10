package com.cppor.codes.jspLearn.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by ZhangHY on 2016/10/9.
 */
public class ChooseTag extends SimpleTagSupport {

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    private boolean flag;

    @Override
    public void doTag() throws JspException, IOException {
        this.getJspBody().invoke(null);
    }
}
