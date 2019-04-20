package com.my.mybatis.entity;

public class AaaaaaBycoustorTypeHander {
    private Long id;
    private String aa;
    private boolean flag;

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

    @Override
    public String toString() {
        return "AaaaaaBycoustorTypeHander{" +
                "id=" + id +
                ", aa='" + aa + '\'' +
                ", flag=" + flag +
                '}';
    }
}
