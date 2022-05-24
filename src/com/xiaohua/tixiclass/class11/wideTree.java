package com.xiaohua.tixiclass.class11;

import com.xiaohua.TreeNode;

import java.util.*;

/**二叉树最大宽度
 * @author xiaohua
 * @create 2022-05-22 2:01
 */
public class wideTree {
    //最基础版的求二叉树宽度  按照实际节点求
    public int widthOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        int max = 0;
        int level=0;
        TreeNode cur = null;
        TreeNode curEnd = root;
        TreeNode nextEnd = null;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            level++;
            cur = queue.poll();

            if (cur.left!=null){
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right!=null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            if (cur == curEnd){

                max = Math.max(max,level);
                level = 0;
                curEnd = nextEnd;
                nextEnd = null;
            }
        }


        return max;

    }



}
