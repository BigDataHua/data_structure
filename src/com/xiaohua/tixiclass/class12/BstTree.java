package com.xiaohua.tixiclass.class12;

import com.xiaohua.TreeNode;

/**
 * @author xiaohua
 * @create 2022-05-23 1:10
 */
public class BstTree {

    class Info{
        boolean isBST;
        int min;
        int max;

        public Info(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        return process(root).isBST;
    }
    public Info process(TreeNode root){
        if (root==null){
            return null;
        }
        Info left = process(root.left);
        Info right = process(root.right);

        int min= root.val;
        int max = root.val;
        if (left!=null){
            min = Math.min(min, left.min);
            max = Math.max(max, left.max);
        }
        if (right!=null){
            min = Math.min(min, right.min);
            max = Math.max(max, right.max);
        }

        boolean isBST = true;
        if (left!=null){
            if (!left.isBST){
                isBST = false;
            }
            if (root.val <= left.max) {
                isBST = false;
            }
        }
        if (right!=null){
            if (!right.isBST){
                isBST = false;
            }
            if (root.val >= right.min) {
                isBST = false;
            }
        }

        return new Info(isBST, min, max);

    }


}
