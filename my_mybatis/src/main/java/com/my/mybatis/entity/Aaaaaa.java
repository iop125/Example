package com.my.mybatis.entity;

public class Aaaaaa {
    private Long id;
    private String aa;

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

    @Override
    public String toString() {
        return "Aaaaaa{" +
                "id=" + id +
                ", aa='" + aa + '\'' +
                '}';
    }
}
