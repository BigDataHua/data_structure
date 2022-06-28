package com.xiaohua.tixiclass.class13;

import com.xiaohua.TreeNode;

/**
 * @author xiaohua
 * @create 2022-06-12 0:44
 */
public class leetcode236 {

    static class Info{
        boolean findA;
        boolean findB;
        TreeNode node;

        public Info(boolean findA, boolean findB, TreeNode node) {
            this.findA = findA;
            this.findB = findB;
            this.node = node;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process(root, p, q).node;
    }

    public static Info process(TreeNode x,TreeNode p ,TreeNode q){

        if (x==null){
            return new Info(false, false, null);
        }
        Info leftInfo = process(x.left, p, q);
        Info rightInfo = process(x.right, p, q);
        boolean findA = (x == p)||leftInfo.findA||rightInfo.findA;
        boolean findB = (x == q)|| leftInfo.findB||rightInfo.findB;
        TreeNode node = null;
        if (leftInfo.node!=null){
            node = leftInfo.node;
        }else if (rightInfo.node!= null){
            node = rightInfo.node;
        }else {
            if (findA&&findB){
                node = x;
            }
        }
        return new Info(findA, findB, node);



    }




}
