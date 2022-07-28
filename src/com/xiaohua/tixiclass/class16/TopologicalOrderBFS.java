package com.xiaohua.tixiclass.class16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author xiaohua
 * @create 2022-06-25 23:53
 */
public class TopologicalOrderBFS {

    // 不要提交这个类
    public static class DirectedGraphNode {
        public int label;
        public ArrayList<DirectedGraphNode> neighbors;

        public DirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<DirectedGraphNode>();
        }
    }



    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph){
        HashMap<DirectedGraphNode, Record> map = new HashMap<>();
        for (DirectedGraphNode directedGraphNode : graph) {
            f(directedGraphNode, map);
        }


        ArrayList<Record> list = new ArrayList<>();
        for (Record record : map.values()) {
            list.add(record);
        }

        list.sort(new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return Long.compare(o2.deep,o1.deep);
            }
        });
        ArrayList<DirectedGraphNode> ans = new ArrayList<>();
        for (Record record : list) {
            ans.add(record.node);
        }
        return ans;


    }

    public static class Record{
        DirectedGraphNode node;
        long deep;
        public Record(DirectedGraphNode n,int d){
            node = n;
            deep = d;
        }
    }

    public static Record f(DirectedGraphNode cur, HashMap<DirectedGraphNode,Record> order){
        if (order.containsKey(cur)){
            return order.get(cur);
        }
        int deep = 0;
        for (DirectedGraphNode neighbor : cur.neighbors) {
            deep+=f(neighbor,order).deep;
        }
        Record ans = new Record(cur, deep + 1);
        order.put(cur,ans);
        return ans;
    }

}
