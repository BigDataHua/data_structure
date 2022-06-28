package com.xiaohua.tixiclass.class16;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

/**
 * @author xiaohua
 * @create 2022-06-25 0:56
 */
public class Dfs {

    public static void Dfs(Node start){
        Stack<Node> stack = new Stack<>();
        HashSet<Node> set = new HashSet<>();
        stack.push(start);
        set.add(start);
        System.out.println(start.value);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node node : cur.next) {
                if (!set.contains(node)) {
                    set.add(node);
                    stack.push(cur);
                    stack.push(node);
                    System.out.println(node.value);
                    break;
                }
            }
        }

    }

}
