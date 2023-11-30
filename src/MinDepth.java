/**
 * 111. 二叉树的最小深度
 *
 * @author kundy
 * @date 2022/5/26 18:31
 */
public class MinDepth {

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

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 如果左右子树都为空，则深度为1
        if (root.left == null && root.right == null) {
            return 1;
        }

        // 程序能执行到这里，证明，左右子树不会同时为空
        // 如果左子树为空，则深度为右子树的最小深度+1
        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        // 如果右子树为空，则深度为左子树的最小深度+1
        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        // 左右子树中深度较小的加根节点（+1）就是整棵树的最小深度
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;

    }

}
