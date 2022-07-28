package com.xiaohua.tixiclass.class16;

import com.sun.glass.ui.Size;
import com.xiaohua.tixiclass.class07.HeapGreater;
import javafx.scene.shape.HLineTo;

import java.util.*;

/**
 * @author xiaohua
 * @create 2022-06-26 1:24
 */
public class unionNODE {

    HashMap<Node,Node> father;
    HashMap<Node, Integer> size;
    ArrayList<Node> help;
    int sets;
    public unionNODE(Collection<Node> coll){
        father = new HashMap<>();
        size = new HashMap<>();
        help = new ArrayList<>();
        sets = 0;
        for (Node node : coll) {
            father.put(node, node);
            size.put(node, 1);
            sets++;
        }
    }

    public Node findFather(Node node){
        help.add(node);
        while (node != father.get(node)) {
            node = father.get(node);
            help.add(node);
        }
        for (Node sun : help) {
            father.put(sun, node);
        }
        return node;
    }

    public boolean isSameSet(Node n1, Node n2) {
        return findFather(n1) == findFather(n2);
    }
    public void union(Node n1,Node n2){
        Node father1 = findFather(n1);
        Node father2 = findFather(n2);
        if (father1!=father2){
            sets--;
            Integer s1 = size.get(father1);
            Integer s2 = size.get(father2);
            if (s1>s2){
                father.put(n2, father1);
                size.put(father1, s1 + s2);
                size.remove(father2);

            }else {
                father.remove(n1, father2);
                size.put(father2, s1 + s2);
                size.remove(father1);
            }
        }

    }



}
