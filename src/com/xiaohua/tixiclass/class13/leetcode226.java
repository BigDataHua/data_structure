package com.xiaohua.tixiclass.class13;

import com.xiaohua.TreeNode;

/**
 * @author xiaohua
 * @create 2022-06-12 0:54
 */
public class leetcode226 {

    public TreeNode invertTree(TreeNode root) {
        return process(root);
    }

    public TreeNode process(TreeNode x){
        if (x==null){
            return null;
        }
        TreeNode left = process(x.left);
        TreeNode right = process(x.right);
        TreeNode tmp = x.left;
        x.left = x.right;
        x.right = tmp;
        return x;

    }

}
