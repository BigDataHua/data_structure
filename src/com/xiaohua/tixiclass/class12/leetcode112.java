package com.xiaohua.tixiclass.class12;

import com.xiaohua.TreeNode;
import jdk.nashorn.internal.ir.IfNode;

/**
 * @author xiaohua
 * @create 2022-05-24 2:14
 */
public class leetcode112 {

    class Info{
        int num;
        boolean flag = false;

        public Info(int num, boolean flag) {
            this.num = num;
            this.flag = flag;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return process(root, new Info(0, false), targetSum).flag;
    }
    public Info process(TreeNode root,Info info,int targetSum){
        if (root==null){
            return new Info(0,false);
        }
        int num = info.num+root.val;
        if (root.left==null&&root.right==null){
            return new Info(num, targetSum == num);
        }
        Info leftPro = process(root.left, new Info(num, false), targetSum);
        Info rightPro = process(root.right, new Info(num, false), targetSum);
        boolean flag= false;
        if (leftPro.flag){
            flag = true;
        }
        if (rightPro.flag){
            flag = true;
        }
        return new Info(num, flag);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6, new TreeNode(8,new TreeNode(7,null,new TreeNode(8)),new TreeNode(3)), null);

    }
}
