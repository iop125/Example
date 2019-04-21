package com.my.mybatis.main;

import com.my.mybatis.dao.ABycoustorResultMapMapper;
import com.my.mybatis.dao.AaaaaaBycoustorObjectFactoryMapper;
import com.my.mybatis.dao.AaaaaaBycoustorTypeHanderMapper;
import com.my.mybatis.dao.AaaaaaMapper1;
import com.my.mybatis.entity.Aaaaaa;
import com.my.mybatis.entity.AaaaaaByResultMap;
import com.my.mybatis.entity.AaaaaaBycoustorObjectFactory;
import com.my.mybatis.entity.AaaaaaBycoustorTypeHander;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class Test1 {

    public static void main(String[] args) throws Exception {

        InputStream inputStream = Resources.getResourceAsStream("myBatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);//配置i 文件的信息变成对象 Configuration configuration
        SqlSession sqlSession = factory.openSession();
        //mybatis的配置文件
        Test1 test1 = new Test1();
//        test1.testInsertData(sqlSession);
//        test1.testCustomTypeHandler(sqlSession);
//        test1.testCustomObejctFactory(sqlSession);
        test1.testResultMap(sqlSession);
        sqlSession.commit();
        sqlSession.close();
    }

    /**
     * 通过类包路径和resource路径配置mapper
     *
     * @param sqlSession
     * @throws Exception
     */
    public void testInsertData(SqlSession sqlSession) {
        //resource
        Aaaaaa a = new Aaaaaa();
        a.setId(new Date().getTime());
        a.setAa("11111");
        sqlSession.insert("AaaaaaDao.insert", a);
        //类包路径
        Aaaaaa a1 = new Aaaaaa();
        a1.setId(new Date().getTime());
        a1.setAa("11111");
        AaaaaaMapper1 mapper = sqlSession.getMapper(AaaaaaMapper1.class);
        mapper.insert(a1);

    }

    /**
     * 自定义的类型转换   可以通过
     *
     * @param sqlSession
     */
    public void testCustomTypeHandler(SqlSession sqlSession) {
        AaaaaaBycoustorTypeHander a = new AaaaaaBycoustorTypeHander();
        a.setId(new Date().getTime());
        a.setAa("333333");
        a.setFlag(true);
        AaaaaaBycoustorTypeHanderMapper mapper = sqlSession.getMapper(AaaaaaBycoustorTypeHanderMapper.class);
//        mapper.insert(a);
        List<AaaaaaBycoustorTypeHander> list = mapper.getA("333333");
        System.out.println("===" + list.toString());
    }

    /**
     * 自定义的类型转换   可以通过
     *
     * @param sqlSession
     */
    public void testCustomObejctFactory(SqlSession sqlSession) {
        AaaaaaBycoustorObjectFactoryMapper mapper = sqlSession.getMapper(AaaaaaBycoustorObjectFactoryMapper.class);
        List<AaaaaaBycoustorObjectFactory> list = mapper.getA("333333");
        System.out.println("===" + list.toString());
    }

    /**
     * ResultMap  返回数据封装到对象中   可以通过
     *
     * @param sqlSession
     */
    public void testResultMap(SqlSession sqlSession) {
        ABycoustorResultMapMapper mapper = sqlSession.getMapper(ABycoustorResultMapMapper.class);
        List<AaaaaaByResultMap> list = mapper.getA("333333");
        System.out.println("===" + list.toString());
    }
}