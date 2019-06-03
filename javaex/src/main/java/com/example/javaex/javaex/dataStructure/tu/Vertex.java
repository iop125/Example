package com.example.javaex.javaex.dataStructure.tu;

/**
 * 顶点类
 */
public class Vertex {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Vertex(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return
                "    value='" + value + '\'';

    }
}
