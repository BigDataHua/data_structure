package com.xiaohua.tixiclass.class10;

import com.xiaohua.TreeNode;


import java.util.Stack;

/**
 * @author xiaohua
 * @create 2022-05-18 21:32
 */
public class basicTreeProble {

    //递归实现二叉树遍历
    public void goTree(TreeNode root){
        //本质递归序
        if (root==null){
            return;
        }
//        System.out.println("nodeValue:"+root.val);
        goTree(root.left);
//        System.out.println("nodeValue:"+root.val);
        goTree(root.right);
        System.out.println("nodeValue:"+root.val);

    }
    //非递归先序
    //弹出栈顶
    //有右进右 有左进左 没有忽略
    public void goPreTreeNoGui(TreeNode root) {
        System.out.println("pre-order");
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cur = null;
        while (!(stack.empty())){
            cur=stack.pop();
            System.out.println("nodeValue"+cur.val);
            if (cur.right!=null){
                stack.push(cur.right);
            }
            if (cur.left!=null){
                stack.push(cur.left);
            }
        }

    }

    //非递归中序
    //当前节点不空 一直向左走，空了就弹栈，输出转右孩子
    public void goInTreeNoGui(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null||(!stack.empty())){
            if (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                System.out.println("nodeValue"+cur.val);
                cur = cur.right;
            }
        }

    }

    //非递归后序
    public void golastTreeNoGui(TreeNode root){
        Stack<TreeNode> treeNodes = new Stack<>();
        Stack<TreeNode> help = new Stack<>();
        treeNodes.push(root);
        TreeNode cur = null;
        while (!treeNodes.empty()){
            cur = treeNodes.pop();
            help.push(cur);
            if (cur.left!=null){
                treeNodes.push(cur.left);
            }
            if (cur.right!=null){
                treeNodes.push(cur.right);
            }
        }
        while (!help.empty()){
            System.out.println("nodeValue"+help.pop().val);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        new basicTreeProble().golastTreeNoGui(root);
        System.out.println();
        new basicTreeProble().goTree(root);
    }

}
