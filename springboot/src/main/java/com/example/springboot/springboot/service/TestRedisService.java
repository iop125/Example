package com.example.springboot.springboot.service;

import com.example.springboot.springboot.domain.ex1.Test;

public interface TestRedisService {

    void add(Test test);

    void get(String id);
}
