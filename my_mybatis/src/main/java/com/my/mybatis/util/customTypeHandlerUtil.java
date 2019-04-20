package com.my.mybatis.util;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义类型转换
 * 在生成sql语句的时候来被调用
 */
public class customTypeHandlerUtil implements TypeHandler {
    /**
     *  当前值如何转换
     * @param ps
     * @param i  占位符的位置
     * @param parameter  数据
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("22222222");

        if(parameter == null){//如果没有值 那就设置一个0
            ps.setInt(i,0);
            return;
        }
       Boolean flag = (Boolean)parameter;
        if(flag){
            ps.setInt(i,1);
        }else{
            ps.setInt(i,0);
        }
        return;

    }

    /**
     * 查询之后将resultset 数据行转换为实体类对象
     * 通知typehandler 将当前数据行某个字段转换为何种类型
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        System.out.println("33333333");
        int flag = rs.getInt(columnName);
        Boolean myFlag = false;
        if(flag ==1 ){
            myFlag = Boolean.TRUE;
        }
        return myFlag;
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
