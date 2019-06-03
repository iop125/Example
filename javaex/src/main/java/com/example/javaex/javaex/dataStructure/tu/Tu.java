package com.example.javaex.javaex.dataStructure.tu;

import java.util.Arrays;

public class Tu {

    public String[] vertex;
    public int currentSize;
    public int[][] adjmat;

    public Tu(int size) {
        this.vertex = new String[size];
        this.adjmat = new int[size][size];
    }

    public void addVertex(Vertex v) {
        //添加顶点
        vertex[currentSize++] = v.getValue();

    }

    /**
     * 顶点
     *
     * @param v1
     * @param v2
     */
    public void addEdge(String v1, String v2) {
        //查找顶点下标
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].equals(v1)) {
                index1 = i;
            }
            if (vertex[i].equals(v2)) {
                index2 = i;
            }
        }
        adjmat[index1][index2] = 1;
        adjmat[index2][index1] = 1;
    }

    public static void main(String[] a) {
        Vertex vertex1 = new Vertex("A");
        Vertex vertex2 = new Vertex("B");
        Vertex vertex3 = new Vertex("C");
        Vertex vertex4 = new Vertex("D");
        Vertex vertex5 = new Vertex("E");
        Tu t = new Tu(5);
        t.addVertex(vertex1);
        t.addVertex(vertex2);
        t.addVertex(vertex3);
        t.addVertex(vertex4);
        t.addVertex(vertex5);
        //增加边
        t.addEdge(vertex1.getValue(),vertex3.getValue());
        t.addEdge(vertex1.getValue(),vertex2.getValue());

        t.addEdge(vertex2.getValue(),vertex3.getValue());
        t.addEdge(vertex2.getValue(),vertex4.getValue());
        t.addEdge(vertex2.getValue(),vertex5.getValue());
        for(int [] b :t.adjmat){
            System.out.println(Arrays.toString(b));
        }
    }
}
