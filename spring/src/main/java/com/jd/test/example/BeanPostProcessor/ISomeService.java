package com.jd.test.example.BeanPostProcessor;

public class ISomeService implements SomeService{
    @Override
    public String doSome() {
        return "Hello+323232";  //返回值变为大写
    }
}
