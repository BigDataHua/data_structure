package com.xiaohua.tixiclass.class16;

import java.util.*;

/**
 * @author xiaohua
 * @create 2022-06-25 23:24
 */
public class TopologySort {


    /**
     * 思路  每次找入度为一的节点  直到结束
     * @param graph
     * @return
     */
    public static List<Node> TopologicalOrderBFS(Graph graph){
        HashMap<Node, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Iterator<Node> nodeIterator = graph.nodes.values().iterator();
        while (nodeIterator.hasNext()){
            Node next = nodeIterator.next();
            map.put(next,next.in);
            if (next.in==0){
                queue.add(next);
            }
        }
        //拿到了所有的节点信息
        ArrayList<Node> result = new ArrayList<>();
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            result.add(cur);
            for (Node node : cur.next) {
                map.put(node,map.get(node)-1);
                if (map.get(node)==0){
                    queue.add(node);
                }

            }
        }

        return result;
    }

}
