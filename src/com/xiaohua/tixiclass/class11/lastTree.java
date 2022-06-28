package com.xiaohua.tixiclass.class11;

import com.xiaohua.TreeNode;

/**中序遍历的后继节点
 * @author xiaohua
 * @create 2022-05-22 2:59
 */
public class lastTree {

    public TreeNode last(TreeNode node) {
        TreeNode ans = null;
        //节点有右孩子
        if (node.right != null) {
            ans = node.right;
            while (ans.left != null) {

                ans = ans.left;
            }
        }else {
            ans = node.parent;
            while (ans.left!=node){
                node = ans;
                ans = ans.parent;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2,new TreeNode(3),new TreeNode(4)), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        root.left.parent=root;
        root.right.parent = root;
        root.left.left.parent= root.left;
        root.left.right.parent=root.left ;
        root.right.right.parent = root.right;
        root.right.left.parent = root.right;
        TreeNode last = new lastTree().last(root.left.right);
        System.out.println(last.val);

    }
}
