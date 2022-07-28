package com.xiaohua.tixiclass.class16;

/**
 * @author xiaohua
 * @create 2022-06-25 0:30
 */
public class Edge {

    int weight;
    Node from;
    Node to;

    public Edge(int w,Node f,Node t){
        weight = w;
        from = f;
        to = t;
    }

}
