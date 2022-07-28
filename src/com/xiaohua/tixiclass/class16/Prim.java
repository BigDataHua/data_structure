package com.xiaohua.tixiclass.class16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author xiaohua
 * @create 2022-06-26 23:53
 */
public class Prim {

    public static void prim(Graph graph){

        PriorityQueue<Edge> edgePriorityQueue = new PriorityQueue<>();

        HashSet<Node> nodeHashSet = new HashSet<>();

        HashSet<Edge> result = new HashSet<>();
        for (Node node : graph.nodes.values()) {
            if (!nodeHashSet.contains(node)){
                nodeHashSet.add(node);
            }
            for (Edge edge : node.edges) {
                edgePriorityQueue.add(edge);
            }
            while (!edgePriorityQueue.isEmpty()){
                Edge curEdge = edgePriorityQueue.poll();
                Node curToNode = curEdge.to;
                if (!nodeHashSet.contains(curToNode)){
                    nodeHashSet.add(curToNode);
                    result.add(curEdge);
                    for (Edge edge : curToNode.edges) {
                        edgePriorityQueue.add(edge);
                    }
                }
            }
            //防止有多个连通图
            break;

        }


    }

}
