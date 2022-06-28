package com.xiaohua.tixiclass.class13;

import com.xiaohua.TreeNode;

/**
 * @author xiaohua
 * @create 2022-06-13 12:25
 */
public class leetcode111 {

    public int minDepth(TreeNode root) {
        return process(root).depth;
    }
    static class Info{

        int depth;

        public Info(int depth) {
            this.depth = depth;
        }
    }


    public static Info process(TreeNode x){
        if (x == null){
            return new Info(Integer.MAX_VALUE);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.left);
        int depth =0;
        if (x.left == null && x.right == null) {
            depth = 1;
            return new Info(depth);
        }

        depth = Math.min(leftInfo.depth, rightInfo.depth);
        return new Info(depth);
    }

}
