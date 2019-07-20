package com.jd.test.manager;

import com.jd.test.domain.Student;

public class TestBugImpl  extends Student implements TestBug {
    private String s;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
