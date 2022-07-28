package com.xiaohua.tixiclass.class16;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author xiaohua
 * @create 2022-06-25 0:31
 */
public class Graph {
    public HashMap<Integer,Node> nodes;
    public HashSet<Edge> edges;
    public Graph(){
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }


}
