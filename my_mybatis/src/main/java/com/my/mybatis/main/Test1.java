package com.my.mybatis.main;

import com.my.mybatis.dao.AaaaaaDao;
import com.my.mybatis.entity.Aaaaaa;
import com.sun.imageio.plugins.common.InputStreamAdapter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test1 {

    public static void main(String[] args) throws IOException {
        //mybatis的配置文件

        Aaaaaa a= new Aaaaaa();
        a.setId(1121L);
        a.setAa("11111");
        InputStream inputStream = Resources.getResourceAsStream("myBatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder() .build(inputStream);
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("AaaaaaDao.insert",a);
        sqlSession.commit();
        sqlSession.close();
    }
}