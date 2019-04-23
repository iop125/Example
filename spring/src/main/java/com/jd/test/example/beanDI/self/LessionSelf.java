package com.jd.test.example.beanDI.self;

import java.util.Arrays;
import java.util.List;

public class LessionSelf {
    /*
    di：Spring框架通过反射机制，调用属性对应的set方法
     */
    private String lessionName;
    private String timeArray[];
    private List<String> school;

    public void setLessionName(String lessionName) {
        this.lessionName = lessionName;
    }

    public void setTimeArray(String[] timeArray) {
        this.timeArray = timeArray;
    }

    public void setSchool(List<String> school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Lession{" +
                "lessionName='" + lessionName + '\'' +
                ", timeArray=" + Arrays.toString(timeArray) +
                ", school=" + school +
                '}';
    }
}
