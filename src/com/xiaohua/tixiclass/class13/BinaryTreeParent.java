package com.xiaohua.tixiclass.class13;

import com.sun.org.apache.regexp.internal.RE;
import com.xiaohua.TreeNode;

/**
 * @author xiaohua
 * @create 2022-06-18 23:25
 */
public class BinaryTreeParent {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return process(root, p, q).parent;
    }

    public static class Info{
        boolean findA;
        boolean findB;
        TreeNode parent;
        public Info(boolean fa,boolean fb,TreeNode pa){
            findA = fa;
            findB = fb;
            parent = pa;
        }
    }

    public static Info process(TreeNode x, TreeNode p, TreeNode q) {
        if (x==null){
            return new Info(false, false, null);
        }
        Info leftInfo = process(x.left, p, q);
        Info rightInfo = process(x.right, p, q);
        boolean findA = leftInfo.findA || rightInfo.findA || x == p;
        boolean findB = leftInfo.findB || rightInfo.findB || x == q;
        TreeNode parent = null;
        if (leftInfo.parent!=null){
            parent = leftInfo.parent;
        }
        if (rightInfo.parent!=null){
            parent = rightInfo.parent;
        }
        if (findA&&findB){
            parent = x;
        }
        return new Info(findA, findB, parent);

    }


}
