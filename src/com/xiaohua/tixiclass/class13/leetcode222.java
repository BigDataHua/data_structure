package com.xiaohua.tixiclass.class13;

import com.xiaohua.TreeNode;



/**
 * @author xiaohua
 * @create 2022-06-11 0:01
 */
public class leetcode222 {

    public int countNodes(TreeNode root) {
        return process(root).sum;
    }

    public static class Info{

        int left;
        int right;
        int sum;

        public Info(int left, int right, int sum) {
            this.left = left;
            this.right = right;
            this.sum = sum;
        }



    }
    public static Info process(TreeNode x){
        if (x==null){
            return new Info(0, 0, 0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int left = leftInfo.sum;
        int right = rightInfo.sum;
        int sum = left+right+1;
        return new Info(left, right, sum);

    }


}
