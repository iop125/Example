package com.my.mybatis.util;

import com.my.mybatis.entity.AaaaaaBycoustorObjectFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

public class CustomObjectFactory extends DefaultObjectFactory {
    @Override
    public <T> T create(Class<T> type) {//只改变要修改的那个对象的 若不是则调用父类的

        if (AaaaaaBycoustorObjectFactory.class == type) {
            AaaaaaBycoustorObjectFactory aaaaaaBycoustorObjectFactory = (AaaaaaBycoustorObjectFactory)super.create(type);
            //设置自定义的规则
            aaaaaaBycoustorObjectFactory.setObjcetFactory("自定义");
            return (T) aaaaaaBycoustorObjectFactory;
        }
        return super.create(type);
    }
}
