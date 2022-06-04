package com.xiaohua.tixiclass.class12;

import com.xiaohua.TreeNode;
import sun.applet.Main;
import sun.reflect.generics.tree.Tree;

/** 是不是满二叉树
 * @author xiaohua
 * @create 2022-06-04 23:05
 */
public class isFullTree {

    public static boolean isfulltree(TreeNode root){

        Info process = process(root);

        return (1<<process.high)-1 == process.size;
    }

    static class  Info{
        int size;
        int high;
        public Info(int s,int h){
            size = s;
            high = h;
        }

    }

    public static Info process(TreeNode x){
        if (x == null){
            return new Info(0,0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int high = 1+Math.max(leftInfo.high,rightInfo.high);
        int size = 1+leftInfo.size+rightInfo.size;

        return new Info(size, high);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(isfulltree(root));
    }
}
