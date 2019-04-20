package com.my.mybatis.main;

import com.my.mybatis.dao.AaaaaaMapper1;
import com.my.mybatis.entity.Aaaaaa;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Test1 {

    public static void main(String[] args) throws IOException {
        //mybatis的配置文件

        Aaaaaa a = new Aaaaaa();
        a.setId(new Date().getTime());
        a.setAa("11111");
        InputStream inputStream = Resources.getResourceAsStream("myBatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);//配置i 文件的信息变成对象 Configuration configuration
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("AaaaaaDao.insert", a);
        Aaaaaa a1 = new Aaaaaa();
        a1.setId(new Date().getTime());
        a1.setAa("11111");
        AaaaaaMapper1 mapper = sqlSession.getMapper(AaaaaaMapper1.class);
        mapper.insert(a1);
        sqlSession.commit();
        sqlSession.close();
    }
}