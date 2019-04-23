package com.jd.test.example.DyNamicFactory;

import com.jd.test.domain.Teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherFatory {

    public Teacher createTeacher(){
        Teacher t = new Teacher();
        System.out.println("--------------");
        return t;
    }

}
