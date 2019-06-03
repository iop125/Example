package com.example.javaex.javaex.dataStructure.tu;

/**
 * 顶点类
 */
public class Vertex {
    private String value;
    private boolean visited;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Vertex(String value) {
        this.value = value;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "value='" + value + '\'' +
                ", visited=" + visited +
                '}';
    }
}
