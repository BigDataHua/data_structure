package com.xiaohua.tixiclass.class16;

import java.util.ArrayList;

/**
 * @author xiaohua
 * @create 2022-06-25 0:31
 */
public class Node {

    int value;
    int in;
    int out;
    ArrayList<Node> next;
    ArrayList<Edge> edges;
    public Node(int v){
        value = v;
        in = 0;
        out = 0;
        next = new ArrayList<Node>();
        edges = new ArrayList<Edge>();
    }


}
