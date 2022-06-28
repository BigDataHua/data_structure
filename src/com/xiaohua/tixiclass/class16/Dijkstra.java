package com.xiaohua.tixiclass.class16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaohua
 * @create 2022-06-27 0:18
 */
public class Dijkstra {

    public static HashMap<Node,Integer> dijkstra1(Node from){

        HashSet<Node> set = new HashSet<>();
        HashMap<Node, Integer> distant = new HashMap<>();
        distant.put(from, 0);
        Node minNode = getMinDistantNode(set, distant);

        while (minNode!=null){
            Integer curDistant = distant.get(minNode);
            for (Edge edge : minNode.edges) {
                Node curNext = edge.to;
                if (!distant.containsKey(curNext)){
                    distant.put(curNext, curDistant + edge.weight);

                }else {
                    distant.put(curNext, Math.min(distant.get(curNext), curDistant + edge.weight));
                }
            }
            set.add(minNode);
            minNode = getMinDistantNode(set, distant);
        }
        return distant;

    }

    private static Node getMinDistantNode(HashSet<Node> set, HashMap<Node, Integer> distant) {
        Node ans = null;
        int ansDistant = Integer.MAX_VALUE;
        Set<Node> nodeSet = distant.keySet();
        for (Node node : nodeSet) {
            if (!set.contains(node)){
                if (ansDistant > distant.get(node)) {
                    ansDistant = distant.get(node);
                    ans = node;
                }
            }
        }
        return ans;
    }

}
