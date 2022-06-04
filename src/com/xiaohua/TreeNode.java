package com.xiaohua;

/**
 * @author xiaohua
 * @create 2022-05-18 21:31
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;

}

    public TreeNode(int val, TreeNode left, TreeNode right, TreeNode parent) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.parent = parent;
    }
}
