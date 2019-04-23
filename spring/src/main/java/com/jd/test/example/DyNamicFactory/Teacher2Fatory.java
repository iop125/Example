package com.jd.test.example.DyNamicFactory;

import com.jd.test.domain.Teacher;

public class Teacher2Fatory {

    public Teacher createTeacher(){
        Teacher t = new Teacher();
        t.setTname("zhangsan");
        System.out.println("--------------222");
        return t;
    }

}
