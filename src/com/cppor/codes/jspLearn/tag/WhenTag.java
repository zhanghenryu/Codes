package com.cppor.codes.jspLearn.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by ZhangHY on 2016/10/9.
 */
public class WhenTag extends SimpleTagSupport {

    public void setTest(boolean test) {
        this.test = test;
    }

    private boolean test;

    @Override
    public void doTag() throws JspException, IOException {
        if (test){
            this.getJspBody().invoke(null);
        }

        ChooseTag ct = (ChooseTag) this.getParent();
        ct.setFlag(test);
    }
}
