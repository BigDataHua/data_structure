package com.xiaohua.tixiclass.class16;

import com.sun.xml.internal.bind.v2.TODO;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**广度优先遍历
 * @author xiaohua
 * @create 2022-06-25 0:48
 */
public class Bfs {

    public static void Bfs(Node start){
        HashSet<Node> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        set.add(start);
        queue.add(start);
        //如果队列不为空，那么还有没有遍历的元素
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            System.out.println(cur.value+" ");
            for (Node node : cur.next) {
                if (!set.contains(node)){
                    queue.add(node);
                    set.add(node);
                }
            }

        }

    }
}
