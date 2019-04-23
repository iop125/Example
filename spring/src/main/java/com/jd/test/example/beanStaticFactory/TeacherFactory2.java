package com.jd.test.example.beanStaticFactory;

import com.jd.test.domain.Teacher;

public class TeacherFactory2 {
    public Teacher createTeacher() {
        Teacher teacher = new Teacher();
        teacher.setTname("Mr");
        System.out.println("TeacherFactory 负责创建 teacher类实例对象..");
        return teacher;
    }
}
