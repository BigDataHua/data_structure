package com.xiaohua.tixiclass.class11;

import com.xiaohua.TreeNode;

import java.util.ArrayList;
import java.util.List;

/** N叉树转二叉树
 * 二叉树 转n叉树
 * @author xiaohua
 * @create 2022-05-22 22:22
 */
public class EncodeNaryTreeToBinaryTree {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    // Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = en(root.children);
        return node;
    }

    private TreeNode en(List<Node> children) {

        if (children==null){
            return null;
        }
        TreeNode head = null;
        TreeNode cur = null;
        for (Node child : children) {
            if (head==null){
                head = new TreeNode(child.val);
                cur = head;
            }else {
                cur.right = new TreeNode(child.val);
            }
            //深度优先
            cur.left=en(child.children);
            cur = cur.right;
        }

        return head;
    }

    public Node decode(TreeNode root) {
        if (root == null) {
            return null;
        }
        return new Node(root.val, de(root.left));
    }

    private List<Node> de(TreeNode root) {
        if (root == null) {
            return null;
        }
        ArrayList<Node> children = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            Node node = new Node(cur.val, de(cur.left));
            children.add(node);
            cur = cur.right;
        }
        return children;
    }


}

