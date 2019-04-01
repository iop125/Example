package com.example.springboot.springboot.dao;

import com.example.springboot.springboot.domain.ex1.Test;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Aatest2Dao {

    int add(Test aatest2);
}
