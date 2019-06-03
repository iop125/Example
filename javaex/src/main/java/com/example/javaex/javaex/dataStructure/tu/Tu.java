package com.example.javaex.javaex.dataStructure.tu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Tu {

    public Vertex[] vertex;
    public int currentSize;
    public int[][] adjmat;
    Stack<Integer> stack = new Stack();
    List<Integer> list = new ArrayList<>();
    Integer weizhi = 0;

    public Tu(int size) {
        this.vertex = new Vertex[size];
        this.adjmat = new int[size][size];
    }

    /**
     * 添加顶点
     *
     * @param v
     */
    public void addVertex(Vertex v) {
        vertex[currentSize++] = v;
    }

    /**
     * 添加边
     *
     * @param v1
     * @param v2
     */
    public void addEdge(Vertex v1, Vertex v2) {
        //查找顶点下标
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i].getValue().equals(v1.getValue())) {
                index1 = i;
            }
            if (vertex[i].getValue().equals(v2.getValue())) {
                index2 = i;
            }
        }
        //通过邻接图保存
        adjmat[index1][index2] = 1;
        adjmat[index2][index1] = 1;
    }

    /**
     * 广度优先算法
     */
    public void bfs() {
        //把第0个顶点标记为访问状态
        vertex[0].setVisited(true);
        //把第0个顶点下标
        list.add(0);
        while (list.size() > 0) {
            for (int i = weizhi + 1; i < vertex.length; i++) {
                if (adjmat[weizhi][i] == 1 && !vertex[i].isVisited()) {
                    list.add(i);
                    vertex[i].setVisited(true);
                }
            }
            System.out.println(vertex[weizhi].getValue());
            list.remove(0);
            if(list.size() > 0)
            weizhi = list.get(0);
        }
    }

    /**
     * 深度优先搜索算法
     */
    public void dfs() {
        //把第0个顶点标记为访问状态
        vertex[0].setVisited(true);
        //把第0个顶点下标
        stack.push(0);
        //打印顶点的值

        System.out.println(vertex[0].getValue());

        out:
        while (!stack.empty()) {
            for (int i = weizhi + 1; i < vertex.length; i++) {
                //如果下一个顶点是通的并且没有遍历过
                if (adjmat[weizhi][i] == 1 && !vertex[i].isVisited()) {
                    //把下个元素押入栈中
                    stack.push(i);
                    vertex[i].setVisited(true);
                    System.out.println(vertex[i].getValue());
                    continue out;
                }
            }
            //弹出栈的元素
            stack.pop();
            //修改当前位置
            if (!stack.empty())
                weizhi = stack.peek();
        }
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
        t.addEdge(vertex1, vertex3);
        t.addEdge(vertex1, vertex2);
        t.addEdge(vertex2, vertex3);
        t.addEdge(vertex2, vertex4);
        t.addEdge(vertex2, vertex5);
        for (int[] b : t.adjmat) {
            System.out.println(Arrays.toString(b));
        }
//        t.dfs();
        t.bfs();
    }
}
