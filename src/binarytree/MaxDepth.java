package binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. 二叉树的最大深度
 *
 * @author kundy
 * @date 2022/5/26 18:31
 */
public class MaxDepth {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // 左右子树中深度较大的加根节点（+1）就是整棵树的最大深度
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
