package com.jd.test.example.beanDI;

import java.util.Arrays;
import java.util.List;

public class Lession {
    /*
    di：Spring框架通过反射机制，调用属性对应的set方法
     */
    private String lessionName;
    private String timeArray[];
    private List<String> school;

    public String getLessionName() {
        return lessionName;
    }

    public void setLessionName(String lessionName) {
        this.lessionName = lessionName;
    }

    public String[] getTimeArray() {
        return timeArray;
    }

    public void setTimeArray(String[] timeArray) {
        this.timeArray = timeArray;
    }

    public List<String> getSchool() {
        return school;
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
