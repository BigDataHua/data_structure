package com.xiaohua.tixiclass.class11;

import com.xiaohua.TreeNode;
import sun.reflect.generics.tree.Tree;


import java.util.*;

/** 二叉树的序列化和反序列化
 * @author xiaohua
 * @create 2022-05-19 13:51
 */
public class TreeWritable {




    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        StringBuffer ans = new StringBuffer();
//        Go(root, ans);
//        return String.valueOf(ans);
//    }
//
//    private void Go(TreeNode root, StringBuffer ans) {
//        if (root == null) {
//            ans.append("null,");
//            return;
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        TreeNode cur = root;
//        stack.add(root);
//
//        while (!stack.empty() ){
//            cur = stack.pop();
//            ans.append(cur.val + ",");
//            if (cur.right!=null){
//                stack.push(cur.right);
//            }else {
//                ans.append("null,");
//            }
//            if (cur.left!=null){
//                stack.push(cur.left);
//            }else {
//                ans.append("null,");
//            }
//
//        }
//
//    }
//
//    // Decodes your encoded data to tree.
////    public TreeNode deserialize(String data) {
////        String[] split = data.split(",");
////        Queue<String> queue = new LinkedList<>();
////        for (int i = 0; i < split.length; i++) {
////            queue.add(split[i]);
////        }
////        if (queue.size() < 1) {
////            return null;
////        }
////
////        return enGo(queue);
////    }
////
////    private TreeNode enGo(Queue<String> queue) {
////        if ("null".equals(queue.peek())){
////            queue.poll();
////            return null;
////        }
////        TreeNode node = new TreeNode(Integer.parseInt(queue.poll()));
////        node.left = enGo(queue);
////        node.right = enGo(queue);
////        return node;
////    }
//
//
//    public TreeNode deserialize(String data) {
//        String[] split = data.split(",");
//        if (split.length < 1) {
//            return null;
//        }
//        int index = 0;
//        TreeNode root = new TreeNode(Integer.parseInt(split[index++]));
//        Queue<TreeNode> queue = new LinkedList<TreeNode>() {
//        };
//        TreeNode cur =null;
//        queue.add(root);
//
//        while (index<split.length){
//            cur = queue.poll();
//
//
//        }
//
//        return root;
//    }
//
//    private TreeNode enGo(Queue<String> queue) {
//        if ("null".equals(queue.peek())){
//            queue.poll();
//            return null;
//        }
//        TreeNode node = new TreeNode(Integer.parseInt(queue.poll()));
//        node.left = enGo(queue);
//        node.right = enGo(queue);
//        return node;
//    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer ans = new StringBuffer();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if (root==null){
            ans.append("null,");
            return ans.toString();
        }
        TreeNode cur = null;
        queue.add(root);
        ans.append(root.val + ",");
        while (!queue.isEmpty()){
            cur =  queue.poll();
            if (cur.left==null){
                ans.append("null,");
            }else {
                ans.append(cur.left.val + ",");
                queue.add(cur.left);
            }
            if (cur.right == null) {
                ans.append("null,");
            }else {
                ans.append(cur.right.val + ",");
                queue.add(cur.right);
            }

        }



        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        if ("null".equals(split[0])){
            return null;
        }
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(split[index++]));
        TreeNode cur = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (index<split.length) {
            cur = queue.poll();
            if ("null".equals(split[index])) {
                index++;
            }else {
                cur.left = new TreeNode(Integer.parseInt(split[index++]));
                queue.add(cur.left);
            }
            if ("null".equals(split[index])) {
                index++;
            }else {
                cur.right = new TreeNode(Integer.parseInt(split[index++]));
                queue.add(cur.right);
            }


        }

        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));

        TreeWritable tw = new TreeWritable();
        String serialize = tw.serialize(root);
        TreeNode root1 = tw.deserialize(serialize);
        System.out.println(root1);
    }

}
