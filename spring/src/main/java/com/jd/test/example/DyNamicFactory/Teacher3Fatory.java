package com.jd.test.example.DyNamicFactory;

import com.jd.test.domain.Teacher;

public class Teacher3Fatory {

    public static Teacher createTeacher(){
        Teacher t = new Teacher();
        t.setTname("zhangsan+static");
        System.out.println("--------------222");
        return t;
    }

}
