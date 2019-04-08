package com.example.springboot.springboot.service.impl;

import com.example.springboot.springboot.domain.ex1.Test;
import com.example.springboot.springboot.service.TestRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("testRedisService")
public class TestRedisServiceImpl implements TestRedisService {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public void add(Test test) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
//        redisTemplate.
        valueOperations.set("21","23234234234");
        String s = (String)valueOperations.get("123");
        System.out.println("-------"+s);
    }

    @Override
    public void get(String id) {
        //获取redis对象
        BoundValueOperations<Object, Object> ops = redisTemplate.boundValueOps("count");
        Object count = ops.get();
        if (count == null) {
            synchronized (this) {
                count = ops.get();
                if (count == null) {
                    count = 1; //非缓存的值
                    ops.set(count, 10, TimeUnit.DAYS);
                }
            }
        }
    }
}
