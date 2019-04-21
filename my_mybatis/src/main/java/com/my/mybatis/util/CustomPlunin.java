package com.my.mybatis.util;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class CustomPlunin implements Interceptor {

    /**
     * 拦截后的实现，对相关业务进行修改
     *
     * @param invocation (代理对象，被监控方法对象。当前被缄口防范运行时需要实参)
     *                   proceed执行方法-反射
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        System.out.println("拦截器执行之前。。。。");
        Object o = invocation.proceed();
        System.out.println("拦截器执行之后");
        return o;
    }

    /**
     * 判断是否被拦截  若是拦截对象则返会一个代理对象  若不是返回实际对象
     *
     * @param target 表示被拦截的对象 应该是Exceutor接口实例对象
     *               若被拦截的对象所在的类有实现接口
     *               就为当前拦截对象生成一个¥proxy
     *               若没有指定接口这个对象之后的行为就不会被代理操作
     * @return
     */
    @Override
    public Object plugin(Object target) {
        ;
        return Plugin.wrap(target, this);
    }

    /**
     * 读取配置信息
     *
     * @param properties
     */
    @Override
    public void setProperties(Properties properties) {

    }
}
