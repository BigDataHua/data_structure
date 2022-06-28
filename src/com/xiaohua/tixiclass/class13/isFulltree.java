package com.xiaohua.tixiclass.class13;

import com.xiaohua.TreeNode;
import sun.reflect.generics.tree.Tree;

import javax.xml.soap.Text;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xiaohua
 * @create 2022-06-16 1:02
 */
public class isFulltree {

    public static boolean isCBT2(TreeNode root){
        if (root==null){
            return true;
        }
        boolean ans = true;
        boolean flag = false;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode q = null;
        queue.add(root);
        while (!queue.isEmpty()){
            q = queue.poll();
            //一旦触发开关（该节点有没有孩子的情况）
            if (!flag){
                if (q.left!=null){
                    queue.add(q.left);
                }else {
                    flag = true;
                }

                if (flag&&q.right!=null){
                    return false;
                }
                if (q.right != null) {
                    queue.add(q.right);
                }else {
                    flag = true;
                }
            }else {
                if (q.left!=null||q.right!=null){
                    return false;
                }
            }


        }


        return ans;
    }

    public static boolean isCBT1(TreeNode head) {
        if (head == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        // 是否遇到过左右两个孩子不双全的节点
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (
                // 如果遇到了不双全的节点之后，又发现当前节点不是叶节点
                    (leaf && (l != null || r != null)) || (l == null && r != null)

                    ) {
                return false;
            }
            if (l != null) {
                queue.add(l);
            }
            if (r != null) {
                queue.add(r);
            }
            if (l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }



    public static class Info{
        boolean isFull;
        boolean isWan;
        int height;

        public Info(boolean isf, boolean isw, int h) {
            isFull = isf;
            isWan = isw;
            height = h;
        }

    }

//    public static boolean isCBT2(TreeNode root) {
//        return process(root).isWan;
//    }
//
//    public static Info process(TreeNode root){
//        if (root==null){
//            return new Info(true, true, 0);
//        }
//        Info leftInfo = process(root.left);
//        Info rightInfo = process(root.right);
//        boolean isFull = false;
//        boolean isWan = false;
//        int height = Math.max(leftInfo.height,rightInfo.height)+1;
//        isFull = leftInfo.isFull && rightInfo.isFull&&(leftInfo.height==rightInfo.height) ? true : false;
//        if (leftInfo.isFull&&leftInfo.height==rightInfo.height&&rightInfo.isFull){
//            isWan = true;
//        }
//        if (leftInfo.isWan&&leftInfo.height==rightInfo.height+1&&rightInfo.isFull){
//            isWan = true;
//        }
//        if (leftInfo.isFull && leftInfo.height == rightInfo.height + 1 && rightInfo.isFull) {
//            isWan = true;
//        }
//        if (leftInfo.isFull && leftInfo.height == rightInfo.height && rightInfo.isWan) {
//            isWan = true;
//        }
//        return new Info(isFull, isWan, height);
//
//    }






    // for test
    public static TreeNode generateRandomBST(int maxLevel, int maxValue) {
        return generate(1, maxLevel, maxValue);
    }

    // for test
    public static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1, maxLevel, maxValue);
        head.right = generate(level + 1, maxLevel, maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int testTimes = 1000000;
        for (int i = 0; i < testTimes; i++) {
            TreeNode head = generateRandomBST(maxLevel, maxValue);
            if (isCBT1(head) != isCBT2(head)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("finish!");
    }



}
