package com.example.springboot.springboot.service.impl;

import com.example.springboot.springboot.dao.Aatest2Dao;
import com.example.springboot.springboot.domain.ex1.Aatest2;
import com.example.springboot.springboot.service.TestMybitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestMybitasSeriviceImpl implements TestMybitasService {

    @Autowired
    private Aatest2Dao aatest2Dao;

    @Transactional  //添加事物注解
    @Override
    public void add(Aatest2 aatest2) {
         aatest2Dao.add(aatest2);
         int i = 3/0;
         aatest2Dao.add(aatest2);
    }
}
