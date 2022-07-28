package com.xiaohua.tixiclass.class14;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/** 手动实现并查集
 * @author xiaohua
 * @create 2022-06-20 23:37
 */
public class UnionFind<V> {

    class Node<V>{
        V v;

        public Node(V v) {
            this.v = v;
        }
    }

    HashMap<V , Node<V>> nodeMap ;
    HashMap<Node<V>, Node<V>> parentMap;
    HashMap<Node<V>, Integer> presentSizeMap ;
    public UnionFind(List<V> list){
        nodeMap = new HashMap<>();
        parentMap = new HashMap<>();
        presentSizeMap = new HashMap<>();
        for (V v : list) {
            Node<V> vNode = new Node<>(v);
            nodeMap.put(v, vNode);
            parentMap.put(vNode, vNode);
            presentSizeMap.put(vNode, 1);
        }

    }

    // 给你一个节点，请你往上到不能再往上，把代表返回
    public Node<V> findFather(Node<V> cur){
        Stack<Node> stack = new Stack<>();
        stack.push(cur);
        while (parentMap.get(cur) != cur) {
            cur = parentMap.get(cur);
            stack.push(cur);
        }
        //将沿途一路的节点都挂到代表节点上
        while (!stack.isEmpty()){
            parentMap.put(stack.pop(), cur);
        }
        return cur;
    }

    public boolean isSameSet(V a, V b){
        return findFather(nodeMap.get(a)) == findFather(nodeMap.get(b));
    }
    public void union(V a, V b){
        Node<V> aNode = findFather(nodeMap.get(a));
        Node<V> bNode = findFather(nodeMap.get(b));
        if (aNode!=bNode){
            Integer aSize = presentSizeMap.get(aNode);
            Integer bSize = presentSizeMap.get(bNode);
            Node<V> big = aSize > bSize ? aNode : bNode;
            Node<V> samll = big == aNode ? bNode : aNode;
            parentMap.put(samll, big);
            presentSizeMap.put(big, presentSizeMap.get(big) + presentSizeMap.get(samll));
            presentSizeMap.remove(samll);
        }


    }
    //返回并查集的个数
    public int sets(){
        return presentSizeMap.size();
    }


}
