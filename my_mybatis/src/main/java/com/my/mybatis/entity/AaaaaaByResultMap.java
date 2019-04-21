package com.my.mybatis.entity;

public class AaaaaaByResultMap {
    private Long id;
    private String aa;
    private boolean flag;
    private String objcetFactory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAa() {
        return aa;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getObjcetFactory() {
        return objcetFactory;
    }

    public void setObjcetFactory(String objcetFactory) {
        this.objcetFactory = objcetFactory;
    }

    @Override
    public String toString() {
        return "AaaaaaBycoustorObjectFactory{" +
                "id=" + id +
                ", aa='" + aa + '\'' +
                ", flag=" + flag +
                ", objcetFactory='" + objcetFactory + '\'' +
                '}';
    }
}
