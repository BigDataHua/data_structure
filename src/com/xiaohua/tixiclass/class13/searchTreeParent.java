package com.xiaohua.tixiclass.class13;

import com.xiaohua.TreeNode;
import sun.misc.LRUCache;

import java.util.ArrayList;

/**
 * @author xiaohua
 * @create 2022-06-19 1:12
 */
public class searchTreeParent {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static int getBSTSize(Node head) {
        if (head == null) {
            return 0;
        }
        ArrayList<Node> arr = new ArrayList<>();
        in(head, arr);
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i).value <= arr.get(i - 1).value) {
                return 0;
            }
        }
        return arr.size();
    }

    public static void in(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        in(head.left, arr);
        arr.add(head);
        in(head.right, arr);
    }

    public static Node maxSubBSTHead1(Node head) {
        if (head == null) {
            return null;
        }
        if (getBSTSize(head) != 0) {
            return head;
        }
        Node leftAns = maxSubBSTHead1(head.left);
        Node rightAns = maxSubBSTHead1(head.right);
        return getBSTSize(leftAns) >= getBSTSize(rightAns) ? leftAns : rightAns;
    }

//    public static Node maxSubBSTHead2(Node head) {
//        if (head == null) {
//            return null;
//        }
//        return process(head).maxSubBSTHead;
//    }
//
//    // 每一棵子树
//    public static class Info {
//        public Node maxSubBSTHead;
//        public int maxSubBSTSize;
//        public int min;
//        public int max;
//
//        public Info(Node h, int size, int mi, int ma) {
//            maxSubBSTHead = h;
//            maxSubBSTSize = size;
//            min = mi;
//            max = ma;
//        }
//    }
//
//    public static Info process(Node X) {
//        if (X == null) {
//            return null;
//        }
//        Info leftInfo = process(X.left);
//        Info rightInfo = process(X.right);
//        int min = X.value;
//        int max = X.value;
//        Node maxSubBSTHead = null;
//        int maxSubBSTSize = 0;
//        if (leftInfo != null) {
//            min = Math.min(min, leftInfo.min);
//            max = Math.max(max, leftInfo.max);
//            maxSubBSTHead = leftInfo.maxSubBSTHead;
//            maxSubBSTSize = leftInfo.maxSubBSTSize;
//        }
//        if (rightInfo != null) {
//            min = Math.min(min, rightInfo.min);
//            max = Math.max(max, rightInfo.max);
//            if (rightInfo.maxSubBSTSize > maxSubBSTSize) {
//                maxSubBSTHead = rightInfo.maxSubBSTHead;
//                maxSubBSTSize = rightInfo.maxSubBSTSize;
//            }
//        }
//        if ((leftInfo == null ? true : (leftInfo.maxSubBSTHead == X.left && leftInfo.max < X.value))
//                && (rightInfo == null ? true : (rightInfo.maxSubBSTHead == X.right && rightInfo.min > X.value))) {
//            maxSubBSTHead = X;
//            maxSubBSTSize = (leftInfo == null ? 0 : leftInfo.maxSubBSTSize)
//                    + (rightInfo == null ? 0 : rightInfo.maxSubBSTSize) + 1;
//        }
//        return new Info(maxSubBSTHead, maxSubBSTSize, min, max);
//    }


    public static Node maxSubBSTHead2(Node head){
        Info process = process(head);
        if (process == null) {
            return null;
        }


        return process.BSTparent;
    }
    public static class Info{
        boolean isBST;
        int min;
        int max;
        int BSTsize;
        Node BSTparent;


        public Info(boolean isb, int mi, int ma,int bss, Node bp) {
            isBST = isb;
            min = mi;
            max = ma;
            BSTsize = bss;
            BSTparent = bp;
        }
    }


    public static Info process(Node x){
        if (x == null) {
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int BSTsize=0;
        Node BSTparent = null;
        int max = x.value;
        int min = x.value;
        if (leftInfo!=null){
            min = Math.min(min, leftInfo.min);
            max = Math.max(max, leftInfo.max);
            BSTsize = leftInfo.BSTsize;
            BSTparent = leftInfo.BSTparent;
        }

        if (rightInfo!=null){
            max = Math.max(max, rightInfo.max);
            min = Math.min(min, rightInfo.min);
            if (rightInfo.BSTsize>(leftInfo==null?0:leftInfo.BSTsize)){
                BSTsize = rightInfo.BSTsize;
                BSTparent = rightInfo.BSTparent;
            }
        }

        boolean isBST=false;
        if ((leftInfo!=null?leftInfo.isBST&&leftInfo.max<x.value:true)
                &&(rightInfo!=null?rightInfo.isBST&&rightInfo.min>x.value:true)){
            isBST = true;
            BSTsize = (leftInfo != null ? leftInfo.BSTsize : 0) + (rightInfo != null ? rightInfo.BSTsize : 0) + 1;
        BSTparent = x;
    }

  return new Info(isBST, min, max, BSTsize, BSTparent);

    }




    // for test
    public static Node generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static Node generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        Node head = new Node((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 4;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            Node head = generateRandomBST(maxLevel, maxValue);
            if (maxSubBSTHead1(head) != maxSubBSTHead2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }


}
