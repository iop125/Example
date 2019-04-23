package com.jd.test.example.BeanPostProcessor.self;

import com.jd.test.example.BeanPostProcessor.SomeService;

public class ISomeServiceSelf implements SomeService{
    @Override
    public String doSome() {
        return "Hello+323232";  //返回值变为大写
    }
}
