package com.xiaohua.tixiclass.class12;

import com.xiaohua.TreeNode;

/**
 * @author xiaohua
 * @create 2022-05-23 0:52
 */
public class BalanceTree {

    class Info{
        int high;
        boolean isBalance;

        public Info(int high, boolean isBalance) {
            this.high = high;
            this.isBalance = isBalance;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return process(root).isBalance;
    }

    public Info process(TreeNode root){
        if (root==null){
            return new Info(0, true);
        }
        Info left = process(root.left);
        Info right = process(root.right);

        int high = Math.max(left.high, right.high) +1;
        boolean isBalance = true;
        if (left.isBalance == false) {
            isBalance = false;
        }
        if (right.isBalance == false) {
            isBalance = false;
        }
        if (Math.abs(left.high-right.high)>1){
            isBalance = false;
        }
        return new Info(high, isBalance);


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3)), new TreeNode(3));
        new BalanceTree().process(root);
    }
}
