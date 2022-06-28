package com.xiaohua.tixiclass.class12;

import com.xiaohua.TreeNode;

/**
 * @author xiaohua
 * @create 2022-05-23 0:45
 */
public class Depth {
    public int maxDepth(TreeNode root) {

        return process(root);
    }

    public int process(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = process(root.left);
        int right = process(root.right);
        int depth = Math.max(left, right)+1;
        return depth;
    }


}
