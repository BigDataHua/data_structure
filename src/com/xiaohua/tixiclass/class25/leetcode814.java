package com.xiaohua.tixiclass.class25;

import com.xiaohua.TreeNode;


/**
 * @author xiaohua
 * @create 2022-07-21 0:39
 */
public class leetcode814 {



    public TreeNode pruneTree(TreeNode root) {

        process(root);
        return (root.val==0&&root.left==null&&root.right==null)?null:root;
    }

    public boolean process(TreeNode x){
        if (x==null){
            return true;
        }
        boolean left = process(x.left);
        boolean right = process(x.right);
        if (left){
            x.left = null;
        }
        if (right){
            x.right = null;
        }
        return left == right && left == true&&x.val==0 ? true : false;
    }
}
