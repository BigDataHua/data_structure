package com.xiaohua.tixiclass.class16;

import java.util.*;

/**
 * @author xiaohua
 * @create 2022-06-26 1:24
 */
public class kruskal {

    public static Set<Edge> kruskalMST(Graph graph){
        //建立好并查集
        unionNODE unionNODE = new unionNODE(graph.nodes.values());
        PriorityQueue<Edge> queue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.weight,o2.weight);
            }
        });
        for (Edge edge : graph.edges) {
            queue.add(edge);
        }
        HashSet<Edge> ans = new HashSet<>();
        while (unionNODE.sets!=1){
            Edge poll = queue.poll();
            if (!unionNODE.isSameSet(poll.from, poll.to)) {
                ans.add(poll);
                unionNODE.union(poll.from, poll.to);
            }
        }

        return ans;
    }


}
